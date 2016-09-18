package shared.inputObjects;

import shared.locations.EdgeLocation;

/**
 * Holds the input parameters needed for PlayRoadBuildingCard()
 */
public class PlayRoadBuildingCardInput extends InputObject {

	/**
	 * The ID of the player playing the road building card
	 */
	int playerID;
	
	/**
	 * The first location for a road to be placed
	 */
	EdgeLocation spot1;
	
	/**
	 * The second location for a road to be placed
	 */
	EdgeLocation spot2;

	/**
	 * Creates an instance of the PlayRoadBuildingCard input parameters object
	 * @param playerID The ID of the player playing the road building card
	 * @param spot1 The first location for a road to be placed
	 * @param spot2 The second location for a road to be placed
	 * @pre 1. playerID is not null and is an existing player<br/>
	 * 		2. spot1 is not null and is a valid EdgeLocation<br/>
	 * 		3. spot2 is not null and is a valid EdgeLoctaion
	 * @post A PlayRoadBuildingCardInput object is created
	 */
	public PlayRoadBuildingCardInput(int playerID, 
									 EdgeLocation spot1, 
									 EdgeLocation spot2) {
		this.playerID = playerID;
		this.spot1 = spot1;
		this.spot2 = spot2;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public EdgeLocation getSpot1() {
		return spot1;
	}

	public void setSpot1(EdgeLocation spot1) {
		this.spot1 = spot1;
	}

	public EdgeLocation getSpot2() {
		return spot2;
	}

	public void setSpot2(EdgeLocation spot2) {
		this.spot2 = spot2;
	}
}
