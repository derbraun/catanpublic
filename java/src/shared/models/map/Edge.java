package shared.models.map;

import shared.models.exceptions.EdgeNotAdjacentException;
import shared.models.exceptions.InvalidRoadPlacementException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import shared.definitions.PlayerIndex;
import shared.definitions.PortType;
import shared.locations.EdgeLocation;

/**
 * Represents an Edge on the Settlers of Catan Map
 * There can be one or two EdgeLocations that point to the same edge
 * An Edge may have one Road placed on top of it
 * An Edge may be associated with one Port 
 * @author Cory
 *
 */
public class Edge {

	/** The Road Placed on the Edge (If there is one) */
	private Road road;
	/** The port associated with the Edge (If there is one) */
	private Port port;
	/** The normalized location of this edge */
	private EdgeLocation loc;
	/** The edges adjacent to this edge */
	private Set<Edge> adjacentEdges;
	
	
	/**
	 * Constructor for Edge
	 * @param loc The Normalized edge location 
	 * 
	 * @pre loc.getNormalizedLocation() = loc
	 * 
	 */
	public Edge(EdgeLocation loc) {
		this.loc = loc.getNormalizedLocation();
	}

	/**
	 * Adds the reference to an adjacent edge (For Construction of Map)
	 * Also passes it's own reference to the edge that was passed in
	 * @param adj The Adjacent Edge
	 * @pre adj != this
	 * @pre adjacentEdges.find(adj) = false
	 * @pre this.adjacentEdges.size < 4
	 * @post this.adjacentEdges.find(adj) = true
	 */
	public void addAdjacentEdge(Edge adj) throws EdgeNotAdjacentException{
		if (this.loc.isAdjacent(adj.loc) && !adjacentEdges.contains(adj)){
			adjacentEdges.add(adj);
		} else {
			throw new EdgeNotAdjacentException("Edges are not adjacent");
		}
		if (!adj.hasAdjacentEdge(this.loc)){
			adj.addAdjacentEdge(this);
		}
	}
	
	/**
	 * Checks if there is an adjacent edge of the normalized edge location
	 * @param loc The normalized location of the adjacent edge
	 * @pre loc.getNormalizedLocation = loc
	 * @return true if exists, false otherwise
	 */
	public boolean hasAdjacentEdge(EdgeLocation location){
		boolean found = false;
		for (Edge elem: adjacentEdges){
			if (elem.loc.getNormalizedLocation().equals(location.getNormalizedLocation())){
				found = true;
			}
		}
		return found;
	}
	
	/**
	 * 
	 * @return true if a Road is on the Edge, false otherwise
	 */
	public boolean hasRoad(){
		return (road != null);
	}
	
	/**
	 * Checks if the Player currently has a road on this edge
	 * @param pIndex A Player index
	 * @return true if there is a Road owned by the indicated Player, false otherwise
	 */
	public boolean hasRoadOfPlayer(PlayerIndex pIndex){
		if (hasRoad()){
			if (road.getPlayerIndex().equals(pIndex)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if the Player may place a road on this edge
	 * @param pIndex
	 * @return
	 */
	public boolean canPlaceRoad(PlayerIndex pIndex){
		if (hasRoad()){
			return false;
		}
		for (Edge elem:adjacentEdges){
			if (elem.hasRoadOfPlayer(pIndex)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Places a road onto this edge owned by indicated player
	 * @param pIndex the Player index of owning player
	 * @pre pIndex != null
	 * @pre this.canPlaceRoad(pIndex) = true
	 * @post hasRoad() = true
	 * @post hasRoadOfPlayer(pIndex) = true
	 * @return The newly placed Road
	 */
	public Road placeRoad(PlayerIndex pIndex) throws InvalidRoadPlacementException{
		if (canPlaceRoad(pIndex)){
			road = new Road(this.loc,pIndex);
		} else {
			throw new InvalidRoadPlacementException("Player cannot build road at this border");
		}
		return road;
	}
	
	/**
	 * Checks if the edge has a port of a particular port type
	 * @param type The type of Port
	 * @return true if the edge has a port of the port type, false otherwise
	 */
	public boolean hasPort(PortType type){
		if (port != null && port.type.equals(type)){
			return true;
		}
		return false;
	}
	
	/**
	 * Finds the longest consecutive road of the player
	 * @param pIndex The index of the player
	 * @pre Road != null
	 * @pre Road.getPlayerIndex() = pIndex
	 * @post return_value >= 1
	 * @return The length of the longest consecutive road
	 */
	public int findLongestRoadOfPlayer(PlayerIndex pIndex){
		
		return 0;
	}
	
	/**
	 * 
	 * @param path
	 * @param pIndex
	 * @return
	 */
	public int findLongestRoadRecursive(Set<EdgeLocation> path, PlayerIndex pIndex){
		int highestFromHere = 0;
		Set<EdgeLocation> currentPath = new HashSet<>(path);
		for(Edge elem : adjacentEdges){
			if (!path.contains(elem.loc)){
				if (elem.hasRoadOfPlayer(pIndex)){
					int numRoads = elem.findLongestRoadRecursive(currentPath, pIndex);
					if (numRoads > highestFromHere){
						highestFromHere = numRoads;
						path = currentPath;
					}
					currentPath.clear();
					currentPath.addAll(path);	
				}
			}
		}
		return highestFromHere;
	}
}
