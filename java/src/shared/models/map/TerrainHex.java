package shared.models.map;

import java.util.Map;

import shared.definitions.HexType;
import shared.definitions.PlayerIndex;
import shared.definitions.PortType;
import shared.locations.EdgeDirection;
import shared.locations.HexLocation;
import shared.locations.VertexDirection;

/**
 * Represents a Hex tile in the Settlers of Catan Map
 * Has exactly 6 vertices ands 6 edges
 * 
 * @author Cory
 *
 */
public class TerrainHex {
	/**
	 * The location of this hex
	 */
	private HexLocation location;
	/**
	 * The type of this hex
	 */
	private HexType terrainType;
	/**
	 * The vertices on this hex
	 */
	private Map<VertexDirection,Vertex> vertices;
	/**
	 * The edges on this hex
	 */
	private Map<EdgeDirection,Edge> edges;
	
	
	public TerrainHex(HexLocation location, HexType terrainType) {
		this.location = location;
		this.terrainType = terrainType;
	}

	/**
	 * Checks to see if a Road can be placed on an Edge at a Direction
	 * 
	 * @param pIndex The index of the player
	 * @param dir The location of the Edge to build on
	 * 
	 * @pre pIndex != null
	 * @pre EdgeDirection != null
	 * 
	 * @return boolean True = Yes, you may place. False = No
	 */
	public boolean canPlaceRoad(PlayerIndex pIndex, EdgeDirection dir) {
		return false;
	}

	/**
	 * Places a Road on an Edge at EdgeLocation
	 * 
	 * @param pIndex The index of the player
	 * @param dir The direction of the Edge to build on
	 * 
	 * @pre pIndex != null
	 * @pre canPlaceRoad(pID,loc) = true
	 * 
	 * @post Edge.Road != null
	 * @post Edge.Road.PlayerID = pID
	 */
	public Road placeRoad(PlayerIndex pIndex, EdgeDirection dir) {
		return null;
	}

	/**
	 * Checks to see if a Settlement can be placed on a Vertex at a VertexDirection
	 * 
	 * @param pIndex The index of the player
	 * @param dir The direction of the Vertex to build on
	 * 
	 * @pre pIndex != null
	 * 
	 * @return boolean True = Yes, you may place. False = No
	 */
	public boolean canPlaceSettlement(PlayerIndex pIndex, VertexDirection dir) {
		return false;
	}

	/**
	 * Places a Settlement on a Vertex at VertexLocation
	 * 
	 * @param pIndex The index of the player
	 * @param loc The location of the Vertex to build on
	 * 
	 * @pre pIndex != null
	 * @pre canPlaceSettlement(pID,dir) = true
	 * 
	 * @post Corner.Building != null
	 * @post Corner.Building.PlayerID = pID
	 * @post Corner.Building.isCity = false
	 */
	public Building placeSettlement(PlayerIndex pIndex, VertexDirection dir) {
		return null;
	}

	/**
	 * Checks to see if a Settlement can be upgraded to a City 
	 * on a Vertex at a VertexLocation
	 * 
	 * @param pIndex The index of the player
	 * @param dir The direction of the Vertex to build on
	 * 
	 * @pre pIndex != null
	 * 
	 * @return boolean True = Yes, you may place. False = No
	 */
	public boolean canUpgradeSettlement(PlayerIndex pIndex, VertexDirection dir) {
		return false;
	}

	/**
	 * Upgrades a Settlement to a City on a Vertex at a VertexLocation
	 * 
	 * @param pID The id of the player
	 * @param dir The direction of the Vertex to build on
	 * 
	 * @pre canUpgradeSettlement(pIndex,dir) = true
	 * 
	 * @post Vertex.Building != null
	 * @post Vertex.Building.PlayerID = pIndex
	 * @post Vertex.Building.isCity = true
	 */
	public void upgradeSettlement(PlayerIndex pIndex, VertexDirection dir) {

	}
	
	/**
	 * Finds the longest road of a Player starting from an Edge
	 * @param pIndex The index of the Player
	 * @param dir The location of the Edge
	 * @pre Edge.hasRoadOfPlayer(pIndex) = true
	 * @return The longest road connected to the road at the starting location
	 */
	public int findLongestRoad(PlayerIndex pIndex, EdgeDirection dir){
		return 0;
	}
	
	/**
	 * Checks to see if the player has a building on a Vertex at a port of a particular type
	 * @param dir the direction of the vertex
	 * @param type the type of port
	 * @return true if player has, false otherwise
	 */
	public boolean isBuildingOnPort(VertexDirection dir, PortType type){
		return false;
	}
	
}
