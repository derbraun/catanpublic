package shared.inputObjects;

/**
 * Holds the input parameters needed for UpdateCurrentGameState()
 */
public class UpdateCurrentGameStateInput extends InputObject {

	/**
	 * The ID of the player requesting the update
	 */
	int playerID;
	
	/**
	 * The current version of the player's model
	 */
	int currentVersion;
	
	/**
	 * Creates an instance of the UpdateCurrentGameState input parameter object
	 * @param playerID the ID of the player requesting the update
	 * @param currentVersion The current version number of the player's model
	 */
	public UpdateCurrentGameStateInput (int playerID,
										int currentVersion)
	{
		this.playerID = playerID;
		this.currentVersion = currentVersion;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public int getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(int currentVersion) {
		this.currentVersion = currentVersion;
	}
}
