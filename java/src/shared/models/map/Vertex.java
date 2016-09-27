package shared.models.map;

import shared.models.exceptions.InvalidBuildingPlacementException;
import java.util.Set;

import shared.definitions.PlayerIndex;
import shared.definitions.PortType;
import shared.locations.VertexLocation;

/**
 * Represents a Vertex on the Settlers of Catan Map
 * There can be one to three VertexLocations that point to the same vertex
 * A Vertex may have one Building placed on top of it
 * @author Cory
 *
 */
public class Vertex {

	/**
	 * The location of this vertex
	 */
	private VertexLocation location;
	
	/**
	 * The building placed on this vertex (if any)
	 */
	private Building building;
	
	/**
	 * The adjacent edges connected to this vertex
	 */
	private Set<Edge> adjacentEdges;
	
	/**
	 * The adjacent vertices connected to this vertex
	 */
	private Set<Vertex> adjacentVertices;
	
	
	/**
	 * @param location The location of this vertex
	 */
	public Vertex(VertexLocation location) {
		this.location = location;
	}

	/**
	 * 
	 * @return true if there is a building, false otherwise
	 */
	public boolean hasBuilding(){
		return false;
	}
	
	/**
	 * @param pIndex The index of the Player
	 * @return true if there is a building owned by the Player, false otherwise
	 */
	public boolean hasBuildingOfPlayer(PlayerIndex pIndex){
		return false;
	}
	
	/**
	 * Checks whether a settlement may be placed at this location by a player
	 * @param pIndex the index of the Player
	 * @return true if player may place settlement, false otherwise
	 */
	public boolean canPlaceSettlement(PlayerIndex pIndex){
		return false;
	}
	
	/**
	 * Places a settlement of a player on this vertex
	 * @param pIndex The index of the Player
	 * @pre pIndex != null
	 * @pre canPlaceSettlement(pIndex) = true
	 * @post building.getPlayerIndex() = pIndex
	 * @return The newly placed building
	 */
	public Building placeSettlement(PlayerIndex pIndex) throws InvalidBuildingPlacementException{
		return null;
	}
	
	/**
	 * Checks whether a player may upgrade their settlement
	 * @param pIndex The index of the Player
	 * @pre hasBuildingOfPlayer(pIndex) = true
	 * @pre building.isUpgraded = false
	 * @post building.isUpgraded = true
	 * @return true if player can upgrade, false otherwise
	 */
	public boolean canUpgradeSettlement(PlayerIndex pIndex){
		return false;
	}
	
	/**
	 * Upgrade the settlement
	 * @param pIndex The index of the Player
	 * @pre canUpgradeSettlement(pIndex) = true
	 * @post building.isUpgraded = true
	 */
	public void upgradeSettlement(PlayerIndex pIndex){
		
	}
	
	/**
	 * Checks if this vertex is on an edge with a port of a particular type
	 * @param type The type of Port
	 * @pre type != null
	 * @return true if its on a port, false otherwise
	 */
	public boolean isOnPort(PortType type){
		return false;
	}
}
