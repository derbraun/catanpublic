package shared.inputObjects;

public class SendChatInput extends InputObject {

	/**
	 * The ID of the player sending the message
	 */
	int playerID;
	
	/**
	 * The message to be added to chat
	 */
	String message;
	
	/**
	 * Creates an instance of the SendChat input parameters object
	 * @param playerID The ID of the player
	 * @param message The message to be added to chat
	 * @pre playerID is not null and message is not null or empty
	 */
	public SendChatInput(int playerID,
						 String message)
	{
		this.playerID = playerID;
		this.message = message;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
