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
	PlayerIndex victimIndex;

	/**
	 * Creates an instance of the RobPlayer input parameters object
	 * @param playerID The ID of the player robbing another player
	 * @param location The new location of the robber
	 * @param victimIndex The player being robbed
	 * @pre 1. playerID is not null and is an existing player<br/>
	 * 		2. location is not null and is a valid HexLocation<br/>
	 * 		3. victimIndex is not null and is an existing player
	 * @post A RobPlayerInput object is created
	 */
	public RobPlayerInput(int playerID, 
						  HexLocation location, 
						  PlayerIndex victimIndex) {
		this.playerID = playerID;
		this.location = location;
		this.victimIndex = victimIndex;
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

	public PlayerIndex getVictimIndex() {
		return victimIndex;
	}

	public void setVictimIndex(PlayerIndex victimIndex) {
		this.victimIndex = victimIndex;
	}
}
