package shared.exceptions;

@SuppressWarnings("serial")
public class ClientServerException
	extends Exception
{
	public ClientServerException() {
		super();
	}

	public ClientServerException(String message) {
		super(message);
	}

	public ClientServerException(Throwable throwable) {
		super(throwable);
	}

	public ClientServerException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
