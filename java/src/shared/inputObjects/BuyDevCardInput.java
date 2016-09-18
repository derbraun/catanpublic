package shared.inputObjects;

/**
 * Holds the input parameters needed for BuyDevCard()
 */
public class BuyDevCardInput extends InputObject {

	/**
	 * The ID of the player buying a dev card
	 */
	int playerID;

	/**
	 * Creates an instance of the BuyDevCard input parameter object
	 * @param playerID The ID of the player buying a dev card
	 * @pre playerID is not null and is an existing player
	 * @post A BuyDevCardInput object is created
	 */
	public BuyDevCardInput(int playerID) {
		this.playerID = playerID;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
}
