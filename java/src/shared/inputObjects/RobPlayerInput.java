package shared.inputObjects;

import shared.locations.HexLocation;

/**
 * Holds the input parameters for RobPlayer()
 */
public class RobPlayerInput extends InputObject {

	/**
	 * The ID of the player robbing another player
	 */
	int playerID;
	
	/**
	 * The new location of the robber
	 */
	HexLocation location;
	
	/**
	 * The player being robbed
	 */
	int victimID;

	/**
	 * Creates an instance of the RobPlayer input parameters object
	 * @param playerID The ID of the player robbing another player
	 * @param location The new location of the robber
	 * @param victimID The player being robbed
	 * @pre 1. playerID is not null and is an existing player<br/>
	 * 		2. location is not null and is a valid HexLocation<br/>
	 * 		3. victimID is not null and is an existing player
	 * @post A RobPlayerInput object is created
	 */
	public RobPlayerInput(int playerID, 
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

	public int getVictimIndex() {
		return victimID;
	}

	public void setVictimIndex(int victimID) {
		this.victimID = victimID;
	}
}
