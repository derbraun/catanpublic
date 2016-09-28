package shared.inputObjects;

import shared.locations.HexLocation;

/**
 * Holds the input parameters needed for PlaySoldierCard()]
 */
public class PlaySoldierCardInput extends InputObject {

	/**
	 * The ID of the player playing the soldier card
	 */
	int playerID;
	
	/**
	 * The new robber location
	 */
	HexLocation location;
	
	/**
	 * The player being robbed (if any)
	 */
	int victimID;

	/**
	 * Creates an instance of the PlaySoldierCard input parameters object
	 * @param playerID The ID of the player playing the soldier card
	 * @param location The new robber location
	 * @param victimID The player being robbed (if any)
	 * @pre 1. playerID is not null and is an existing player<br/>
	 * 		2. location is not null and is a valid HexLocation<br/>
	 * 		3. victimID is not null and is an existing player
	 * @post A PlaySoldierCardInput object is created
	 */
	public PlaySoldierCardInput(int playerID, 
								HexLocation location, 
								int victimID) {
		this.playerID = playerID;
		this.location = location;
		this.victimID = victimID;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public HexLocation getLocation() {
		return location;
	}

	public void setLocation(HexLocation location) {
		this.location = location;
	}

	public int getVictimID() {
		return victimID;
	}

	public void setVictimID(int victimID) {
		this.victimID = victimID;
	}
}
