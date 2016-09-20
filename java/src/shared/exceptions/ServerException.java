package shared.exceptions;

import shared.exceptions.ClientServerException;

@SuppressWarnings("serial")
public class ServerException
	extends ClientServerException 
{

	public ServerException() {
		super();
	}

	public ServerException(String message) {
		super(message);
	}

	public ServerException(Throwable throwable) {
		super(throwable);
	}

	public ServerException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
