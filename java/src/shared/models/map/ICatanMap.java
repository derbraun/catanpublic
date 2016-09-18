package shared.models.map;

import shared.definitions.PlayerIndex;
import shared.definitions.PortType;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexLocation;

/**
 * Interface of calls made to a Map of Settlers of Catan
 * @author Cory
 *
 */
public interface ICatanMap {

	/**
	 * Checks to see if a Robber can be placed at a HexPosition
	 * 
	 * @param loc New robber position
	 * 
	 * @return boolean True = Yes, you may place. False = No
	 */
	public boolean canPlaceRobber(HexLocation loc);
	
	/**
	 * Places the Robber on a HexLocation
	 * 
	 * @param loc New robber position
	 * 
	 * @pre canPlaceRobber(loc) = true
	 * 
	 * @post new robberLocation = loc
	 */
	public void placeRobber(HexLocation loc);
	
	/**
	 * Checks to see if a Road can be placed on an Edge at a EdgeLocation
	 * 
	 * @param pIndex The index of the player
	 * @param loc The location of the Edge to build on
	 * 
	 * @pre pIndex != null
	 * 
	 * @return boolean True = Yes, you may place. False = No
	 */
	public boolean canPlaceRoad(PlayerIndex pIndex, EdgeLocation loc);
	
	/**
	 * Places a Road on an Edge at EdgeLocation
	 * 
	 * @param pIndex The index of the player
	 * @param loc The location of the Edge to build on
	 * 
	 * @pre pIndex != null
	 * @pre canPlaceRoad(pID,loc) = true
	 * 
	 * @post Edge.Road != null
	 * @post Edge.Road.PlayerID = pID
	 */
	public void placeRoad(PlayerIndex pIndex, EdgeLocation loc) 
			throws InvalidRoadPlacementException;
	
	/**
	 * Checks to see if a Settlement can be placed on a Vertex at a VertexLocation
	 * 
	 * @param pIndex The index of the player
	 * @param loc The location of the Vertex to build on
	 * 
	 * @pre pIndex != null
	 * 
	 * @return boolean True = Yes, you may place. False = No
	 */
	public boolean canPlaceSettlement(PlayerIndex pIndex, VertexLocation loc);
	
	/**
	 * Places a Settlement on a Vertex at VertexLocation
	 * 
	 * @param pIndex The index of the player
	 * @param loc The location of the Corner to build on
	 * 
	 * @pre pIndex != null
	 * @pre canPlaceSettlement(pID,loc) = true
	 * 
	 * @post Vertex.Building != null
	 * @post Vertex.Building.PlayerID = pID
	 * @post Vertex.Building.isCity = false
	 */
	public void placeSettlement(PlayerIndex pIndex, VertexLocation loc)
	throws InvalidBuildingPlacementException;
	
	/**
	 * Checks to see if a Settlement can be upgraded to a City 
	 * on a Vertex at a VertexLocation
	 * 
	 * @param pIndex The index of the player
	 * @param loc The location of the Vertex to build on
	 * 
	 * @pre pIndex != null
	 * 
	 * @return boolean True = Yes, you may place. False = No
	 */
	public boolean canUpgradeSettlement(PlayerIndex pIndex, VertexLocation loc);
	
	/**
	 * Upgrades a Settlement to a City on a Vertex at a VertexLocation
	 * 
	 * @param pID The id of the player
	 * @param loc The location of the Vertex to build on
	 * 
	 * @pre canUpgradeSettlement(pIndex,loc) = true
	 * 
	 * @post Vertex.Building != null
	 * @post Vertex.Building.PlayerID = pIndex
	 * @post Vertex.Building.isCity = true
	 */
	public void upgradeSettlement(PlayerIndex pIndex, VertexLocation loc) 
			throws BuildingNotUpgradableException;
	
	/**
	 * Reports the longest continuous road that the player owns
	 * 
	 * @param pIndex The index of the player
	 * 
	 * @pre pIndex != null
	 * 
	 * @return int The highest number of consecutive roads the player has
	 */
	public int getLongestRoadOfPlayer(PlayerIndex pIndex);
	
	/**
	 * Reports the Production Results of a die roll into a passed 
	 * in ResProdResult. Client may then extract the data from the
	 * ResProdResult Object
	 * 
	 * @param dieRoll The result of the roll of dice
	 * 
	 * @pre dieRoll = [2-12]
	 * 
	 * @post ResProdResult accurately records who gets resources and how much
	 * 
	 * @return ResProdResult The Production Results
	 */
	public ResProdResult getResourceProductionResults(int dieRoll);
	
	/**
	 * Checks to see if a Player has a building on a port of a certain type
	 * 
	 * @param type The type of the Harbor
	 * @param pIndex The index of the player
	 * 
	 * @pre pIndex != null
	 * @pre type != null
	 * 
	 * @return true if player does have a building on a port of that type. false otherwise
	 */
	public boolean doesPlayerHavePort(PlayerIndex pIndex, PortType type);
	
	/**
	 * Reports the number of roads that a player has currently on the CatanMap
	 * 
	 * @param pIndex The index of the player
	 * 
	 * @pre pIndex != null
	 * 
	 * @return int the total number of roads the player has placed on the map
	 */
	public int numRoadsOfPlayer(PlayerIndex pIndex);
	
	/**
	 * Reports the number of settlements that a player has currently on the CatanMap
	 * 
	 * @param pIndex The index of the player
	 * 
	 * @pre pIndex != null
	 * 
	 * @return int the total number of settlements the player has placed on the map
	 */
	public int numSettlementsOfPlayer(PlayerIndex pIndex);
	
	/**
	 * Reports the number of cities that a player has currently on the CatanMap
	 * 
	 * @param pIndex The index of the player
	 * 
	 * @pre pIndex != null
	 * 
	 * @return int the total number of cities the player has placed on the map
	 */
	public int numCitiesOfPlayer(PlayerIndex pIndex);
	
}
