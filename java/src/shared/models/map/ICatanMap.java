package shared.models.map;

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
	 * Checks to see if a Road can be placed on a Border at a BorderLocation
	 * 
	 * @param pID The id of the player
	 * @param loc The location of the Border to build on
	 * 
	 * @pre pID = [0-3]
	 * 
	 * @return boolean True = Yes, you may place. False = No
	 */
	public boolean canPlaceRoad(int pID, EdgeLocation loc);
	
	/**
	 * Places a Road on a Border at BorderLocation
	 * 
	 * @param pID The id of the player
	 * @param loc The location of the Border to build on
	 * 
	 * @pre canPlaceRoad(pID,loc) = true
	 * 
	 * @post Border.Road != null
	 * @post Border.Road.PlayerID = pID
	 */
	public void placeRoad(int pID, EdgeLocation loc);
	
	/**
	 * Checks to see if a Settlement can be placed on a Corner at a CornerLocation
	 * 
	 * @param pID The id of the player
	 * @param loc The location of the Corner to build on
	 * 
	 * @pre pID = [0-3]
	 * 
	 * @return boolean True = Yes, you may place. False = No
	 */
	public boolean canPlaceSettlement(int pID, VertexLocation loc);
	
	/**
	 * Places a Settlement on a Corner at CornerLocation
	 * 
	 * @param pID The id of the player
	 * @param loc The location of the Corner to build on
	 * 
	 * @pre canPlaceSettlement(pID,loc) = true
	 * 
	 * @post Corner.Building != null
	 * @post Corner.Building.PlayerID = pID
	 * @post Corner.Building.isCity = false
	 */
	public void placeSettlement(int pID, VertexLocation loc);
	
	/**
	 * Checks to see if a Settlement can be upgraded to a City 
	 * on a Corner at a CornerLocation
	 * 
	 * @param pID The id of the player
	 * @param loc The location of the Corner to build on
	 * 
	 * @pre pID = [0-3]
	 * 
	 * @return boolean True = Yes, you may place. False = No
	 */
	public boolean canUpgradeSettlement(int pID, VertexLocation loc);
	
	/**
	 * Upgrades a Settlement to a City on a Corner at a CornerLocation
	 * 
	 * @param pID The id of the player
	 * @param loc The location of the Corner to build on
	 * 
	 * @pre canUpgradeSettlement(pID,loc) = true
	 * 
	 * @post Corner.Building != null
	 * @post Corner.Building.PlayerID = pID
	 * @post Corner.Building.isCity = true
	 */
	public void upgradeSettlement(int pID, VertexLocation loc);
	
	/**
	 * Reports the longest continuous road that the player owns
	 * 
	 * @param pID The id of the player
	 * 
	 * @pre pID = [0-3]
	 * 
	 * @return int The highest number of consecutive roads the player has
	 */
	public int getLongestRoadOfPlayer(int pID);
	
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
	 * Checks to see if a Player has a building on a harbor of a certain type
	 * 
	 * @param pID The id of the player
	 * @param type The type of the Harbor
	 * 
	 * @pre pID = [0-3]
	 * @pre type != null
	 * 
	 * @return true if player does have a building on a harbor of that type. false otherwise
	 */
	public boolean doesPlayerHavePort(int pID, PortType type);
	
	/**
	 * Reports the number of roads that a player has currently on the CatanMap
	 * 
	 * @param pID The id of the player
	 * 
	 * @pre pID = [0-3]
	 * 
	 * @return int the total number of roads the player has placed on the map
	 */
	public int numRoadsOfPlayer(int pID);
	
	/**
	 * Reports the number of settlements that a player has currently on the CatanMap
	 * 
	 * @param pID The id of the player
	 * 
	 * @pre pID = [0-3]
	 * 
	 * @return int the total number of settlements the player has placed on the map
	 */
	public int numSettlementsOfPlayer(int pID);
	
	/**
	 * Reports the number of cities that a player has currently on the CatanMap
	 * 
	 * @param pID The id of the player
	 * 
	 * @pre pID = [0-3]
	 * 
	 * @return int the total number of cities the player has placed on the map
	 */
	public int numCitiesOfPlayer(int pID);
	
}
