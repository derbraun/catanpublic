package shared.inputObjects;

/**
 * Holds the input parameters needed for FinishTurn()
 */
public class FinishTurnInput extends InputObject {

	/**
	 * The ID of the player finishing their turn
	 */
	int playerID;

	/**
	 * Creates an instance of the FinishTurn input parameter object
	 * @param playerID The ID of the player finishing their turn
	 * @pre playerID is not null and is an existing player
	 * @post A FinishTurnInput object is created
	 */
	public FinishTurnInput(int playerID) {
		this.playerID = playerID;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
}
