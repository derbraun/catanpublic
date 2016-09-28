package communicators;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import shared.exceptions.ClientException;
import shared.inputObjects.InputObject;
import shared.outputObjects.OutputObject;

/**
 * The ClientCommunicator class
 * @author Dell
 *
 */
public class ClientCommunicator {
	
	public static ClientCommunicator SINGLETON = new ClientCommunicator();
	
	//Auxiliary Constants, Attributes, and Methods
	private static String serverHost = "localhost";
	private static int serverPort = 8080;
	public static String URL_PREFIX = "http://" + serverHost + ":" + serverPort;
	private static final String HTTP_GET = "GET";
	private static final String HTTP_POST = "POST";
	private final int UNKNOWN_RESPONSE_LENGTH = -1;
	private static final int MIN_PORT_NUMBER = 1;
	private static final int MAX_PORT_NUMBER = 65535;
	
	private XStream xmlStream;
	
	/**
	 * Creates an instance of the ClientCommunicator class
	 * @pre none
	 * @post A ClientCommunicator object
	 */
	private ClientCommunicator() {
		xmlStream = new XStream(new DomDriver());
	}
	
	/** 
	 * Sets the server host
	 * @param host The new server host
	 */
	public void setHost(String host) {
	
		serverHost = host;
		
		URL_PREFIX = "http://" + serverHost + ":" + serverPort;
	}
	
	/**
	 *  Sets the server port
	 * @param port The new server port
	 */
	public void setPort(String port) {
		
		if(port != null) {
			
			try {

				int newPort = Integer.parseInt(port);
				
				if (newPort >= MIN_PORT_NUMBER && newPort < MAX_PORT_NUMBER) {
					
					serverPort = newPort;
					
					URL_PREFIX = "http://" + serverHost + ":" + serverPort;
				}
			} catch (Exception e) {
				
			}

		}
	}

	/**
	 * Packages the requested operation to be performed and sends it to the server
	 * @param commandName A string containing the name of the requested operation
	 * @param input The object containing the input parameters of the requested operation
	 * @return An object containing all the output parameters of the requested operation
	 * @throws ClientException 
	 * @pre operation and object are not null
	 * @post The output parameters are returned in an OutputObject
	 */
	public OutputObject Send(String commandName, InputObject input) throws ClientException {
		
		assert commandName != null;
		assert input != null;
		
		Object result = null;
		
		try {
			
			URL url = new URL(URL_PREFIX + "/" + commandName);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod(HTTP_POST);
			connection.setDoOutput(true);
			connection.connect();
			xmlStream.toXML(input, connection.getOutputStream());
			connection.getOutputStream().close();
			
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				
				// If the response length is equal to -1, then the length is unknown
				if (connection.getContentLength() == UNKNOWN_RESPONSE_LENGTH) {
					
					result = xmlStream.fromXML(connection.getInputStream());
				}
				else if (connection.getContentLength() > 0) {
					
					throw new ClientException(String.format("send failed: %s the content length must be a -1 or 0", commandName));
				}
			}
			else {
				
				throw new ClientException(String.format("send failed: %s (http code %d)", commandName, connection.getResponseCode()));
			}
		} catch (IOException e) {
			
			throw new ClientException(String.format("send failed: %s", e.getMessage()), e);
		}
		
		return (OutputObject) result;
	}
	
	/**
	 * Gets and unpackages the information sent from the server
	 * @param fileName The name of the file to be retrieved
	 * @return An object containing the result
	 * @throws ClientException 
	 * @pre fileName is not null
	 * @post An object containing the result 
	 */
	public OutputObject Get(String fileName) throws ClientException {
		
		assert fileName != null && fileName.length() > 0;
		
		Object result = null;
		try {
			URL url = new URL(URL_PREFIX + "/" + fileName);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod(HTTP_GET);
			connection.connect();
			
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				//Assumption: On a get, the server will return the number of bytes
				//in the response body.
				if(connection.getContentLength() >= 0) {
					result = xmlStream.fromXML(connection.getInputStream());
				} else {
					throw new ClientException(
							String.format("get failed: %s, the content length must be >= 0", fileName));
				}
			} else {
				throw new ClientException(String.format("get failed: %s (http code %d)",
						fileName, connection.getResponseCode()));
			}
		}
		catch (IOException e) {
			throw new ClientException(String.format("get failed: %s", e.getMessage()), e);
		}
		return (OutputObject)result;
	}
}
