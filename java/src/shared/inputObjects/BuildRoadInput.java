package shared.inputObjects;

import shared.locations.EdgeLocation;

/**
 * Holds the input parameters needed for BuildRoad()
 */
public class BuildRoadInput extends InputObject {

	/**
	 * The ID of the player to build a road
	 */
	int playerID;
	
	/**
	 * Indicates whether the road piece is free or requires resources
	 */
	boolean isFree;
	
	/**
	 * The location for the road to be placed
	 */
	EdgeLocation roadLocation;

	/**
	 * Creates an instance of the BuildRoad input parameters object
	 * @param playerID The ID of the player to build a road
	 * @param isFree Indicates whether the road piece is free or requires resources
	 * @param roadLocation The location for the road to be placed
	 * @pre 1. playerID is not null and is an existing player<br/>
	 * 		2. isFree is a valid boolean value<br/>
	 * 		3. roadLocation is not null and is a valid EdgeLocation
	 * @post A BuildRoadInput object is created
	 */
	public BuildRoadInput(int playerID, 
						  boolean isFree, 
						  EdgeLocation roadLocation) {
		this.playerID = playerID;
		this.isFree = isFree;
		this.roadLocation = roadLocation;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public EdgeLocation getRoadLocation() {
		return roadLocation;
	}

	public void setRoadLocation(EdgeLocation roadLocation) {
		this.roadLocation = roadLocation;
	}
}
