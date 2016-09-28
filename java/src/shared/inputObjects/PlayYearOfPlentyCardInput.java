package shared.inputObjects;

import shared.definitions.ResourceType;

/**
 * Holds the input parameters needed for PlayYearOfPlentyCard()
 */
public class PlayYearOfPlentyCardInput extends InputObject {

	/**
	 * The ID of the player playing the year of plenty card
	 */
	int playerID;
	
	/**
	 * The first resource the player wants to receive
	 */
	ResourceType resource1;
	
	/**
	 * The second resource the player wants to receive
	 */
	ResourceType resource2;

	/**
	 * Creates an instance of the PlayYearOfPlentyCard input parameters object
	 * @param playerID The ID of the player playing the year of plenty card
	 * @param resource1 The first resource the player wants to receive
	 * @param resource2 The second resource the player wants to receive
	 * @pre 1. playerID is not null and is an existing player<br/>
	 * 		2. resource1 is not null and is a valid resource<br/>
	 * 		3. resource2 is not null and is a valid resource<br/>
	 * @post A PlayYearOfPlentyCardInput object is created
	 */
	public PlayYearOfPlentyCardInput(int playerID, 
									 ResourceType resource1, 
									 ResourceType resource2) {
		this.playerID = playerID;
		this.resource1 = resource1;
		this.resource2 = resource2;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public ResourceType getResource1() {
		return resource1;
	}

	public void setResource1(ResourceType resource1) {
		this.resource1 = resource1;
	}

	public ResourceType getResource2() {
		return resource2;
	}

	public void setResource2(ResourceType resource2) {
		this.resource2 = resource2;
	}
}
