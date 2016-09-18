package shared.inputObjects;

/**
 * Holds the input parameters needed for AcceptTrade()
 */
public class AcceptTradeInput extends InputObject {

	/**
	 * The ID of the player on the receiving end of a trade offer
	 */
	int playerID;
	
	/**
	 * Indicates whether the player accepts the trade or not
	 */
	boolean willAccept;

	/**
	 * Creates an instance of the AcceptTrade input parameters object
	 * @param playerID The ID of the player on the receiving end of a trade offer
	 * @param willAccept Indicates whether the player accepts the trade or not
	 * @pre playerID is not null and is an existing player, and willAccept is a valid boolean value
	 */
	public AcceptTradeInput(int playerID, 
							boolean willAccept) {
		this.playerID = playerID;
		this.willAccept = willAccept;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public boolean isWillAccept() {
		return willAccept;
	}

	public void setWillAccept(boolean willAccept) {
		this.willAccept = willAccept;
	}
}
