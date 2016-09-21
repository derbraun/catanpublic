package client.poller;

import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/**
 * The poller polls the server at regular intervals, and it runs independent of other code.
 * Poller implementation may use java.util.Timer or java.util.TimerTask
 */

public class Poller 
{
	/**
	 * controller is the variable to which the updated model details will be sent whenever the server sends back updated information through the proxy
	 */
	private catan.java.src.client.base.Controller controller;//initialized in the constructor
	
	
	/**
	 * proxy is the server proxy by which the PollTask will communicate with the server
	 */
	private catan.java.src.shared.IServer proxy;//will be initialized in the setProxy method
	
	
	/**
	 * t is simply used to set up a PollTask TimerTask.  It will also be used to cancel the timer task once the game is finished.
	 */
	private Timer timer;//will be created in the poller constructor; scheduleAtFixedRate will be performed on t using PollTask TimerTask in constructor, as well
	
	
	/**
	 * The constructor for the Poller.  Here, the con parameter will be assigned to be the controller variable, the timer will be initialized, the TimerTask scheduleAtFixedInterval,
	 * and the prox parameter will be assigned to be the proxy variable
	 * @pre con parameter must be valid instance of Controller.java; prox parameter must be a valid implementation of IServer-- either a mock server proxy, or a real server proxy.
	 * Here, valid means the object is initialized and implements all required methods, as defined here, i.e. model replacement in controller, server contact in proxy, etc. 
	 * @post after calling the constructor, the PollTask will immediately begin to speak to the server proxy.  Whether or not correct data comes back is dependent upon the connection
	 * between the proxy and the server.  Polling will continue until the controller calls the Poller to have the TimerTask cancelled.
	 * @param con the game's controller, established by the client executable
	 * @param prox the server proxy to be used by the game to communicate with the server
	 */
	public Poller (catan.java.src.client.base.Controller con, catan.java.src.shared.IServer prox)//takes game's controller as parameter;  the controller will not change over the life of the game
	{
	}
	
	/**
	 * Although the proxy is set up from the constructor of the Poller object, a setProxy method is in place for testing purposes.
	 * @pre prox parameter must be a valid implementation of IServer-- either a mock server proxy, or a real server proxy.
	 * Here, valid means the object is initialized and implements all required methods, as defined here, i.e. server contact in proxy.
	 * @post Any subsequent executions of the PollTask's run method will utilize the server proxy object passed in as prox in this method
	 * @param prox the server proxy to be used by the game to communicate with the server
	 */
	public void setProxy(catan.java.src.shared.IServer prox)//to support dependency injection
	{
	}
	
	/**
	 * 
	 * @pre the proxy variable was initialized to an existing, functional server proxy object.
	 * @post the viable proxy variable is successfully passed to the method which calls getProxy, specifically the PollTask
	 * @return the game's current working server proxy
	 */
	protected catan.java.src.shared.IServer getProxy()//returns proxy to be used by PollTask
	{
	}
	
	/**
	 * once the game is complete and there is no longer any need for the poller to check the server for updates, the controller can have the poller cancel the PollTask TimerTask.
	 * @pre The timer must have been initialized (which is implicit given the construction of this Poller object).
	 * @post The Poller no longer checks for updates.
	 */
	public void cancelTimer()//Discards PollTask from Timer timer
	{
	}
	
	/**
	 * The poller requests the current model version from the controller.  This number is passed on to object calling the getModelVersion method, specifically the PollTask TimerTask.
	 * @pre the Poller must have a reference to a functional controller (implicit in the construction of the Poller object).
	 * @post the PollTask will have the most current version number to pass to the server proxy.
	 * @return the most current model version number, as defined by the controller.
	 */
	protected int getModelVersion()//will only be called by PollTask;  returns the model version so that can be included by polltask in proxy request
	{
		//TODO: Need to check if the model version will just be an int
	}
	
	/**
	 * The poller requests the ID of the player whose turn it currently is.  This number is passed on to object calling the getCurrentPlayer method, specifically the PollTask TimerTask.
	 * @pre the Poller must have a reference to a functional controller (implicit in the construction of the Poller object).
	 * @post the PollTask will have the ID of the player whose turn it currently is, to pass to the server proxy.
	 * @return the ID of the player whose turn it currently is.
	 */
	protected catan.java.src.shared.definitions.PlayerIndex getCurrentPlayer()//gets player index to be passed on to PollTask
	{
	}
	
	/**
	 * The PollTask will call this on the Poller if the former received updated information from the server.  The controller will have the responsibility of updating the model.
	 * @pre The JSONObject must conform to the model template established by the server/game.  Also, the Poller must have a reference to a functional controller
	 *  (implicit in the construction of the Poller object).
	 * @post the controller will have all necessary information to update the model to the most current version.
	 * @param json A JSONObject which conforms to the template established by the server.  This object must have at least one field different from the existing model.
	 */
	protected void sendJSON(JSONObject json)//gives the JSONObject to the controller, which will subsequently make the necessary changes to the model object
	{
	}
}
