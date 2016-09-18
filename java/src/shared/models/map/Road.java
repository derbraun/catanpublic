package shared.models.map;

import shared.definitions.PlayerIndex;
import shared.locations.EdgeLocation;

/**
 * Represents a road that is placed on 
 * the Settlers of Catan map. 
 * @author Cory
 *
 */
public class Road {
	
	private EdgeLocation location;
	private PlayerIndex pIndex;
	
	
	/**
	 * Creates a new Road at the Edge location
	 * @param location The location
	 * @param pIndex The index of the owning player
	 */
	public Road(EdgeLocation location, PlayerIndex pIndex) {
		this.location = location;
		this.pIndex = pIndex;
	}

	/**
	 * @return the location
	 */
	public EdgeLocation getLocation() {
		return location;
	}

	/**
	 * @return the index of the owning player
	 */
	public PlayerIndex getPlayerIndex() {
		return pIndex;
	}
	
}
