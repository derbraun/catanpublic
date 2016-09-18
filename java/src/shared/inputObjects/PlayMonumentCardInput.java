package shared.inputObjects;

/**
 * Holds the input parameters needed for PlayMonumentCard()
 */
public class PlayMonumentCardInput extends InputObject {

	/**
	 * The ID of the player playing the monument card
	 */
	int playerID;

	/**
	 * Creates an instance of the PlayMonumentCard input parameters object
	 * @param playerID The ID of the player playing the monument card
	 * @pre playerID is not null and is an existing player
	 * @post A PlayMonumentCardInput object is created
	 */
	public PlayMonumentCardInput(int playerID) {
		this.playerID = playerID;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
}
