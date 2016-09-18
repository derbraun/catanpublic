package client;

import shared.ClientServerException;

@SuppressWarnings("serial")
public class ClientException
	extends ClientServerException
{

	public ClientException() {
		super();
	}

	public ClientException(String message) {
		super(message);
	}

	public ClientException(Throwable throwable) {
		super(throwable);
	}

	public ClientException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
