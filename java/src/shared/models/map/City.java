package shared.models.map;

import shared.definitions.PlayerIndex;
import shared.locations.VertexLocation;

/**
 * Represents a city that is placed on 
 * the Settlers of Catan map. 
 * @author Cory
 *
 */
public class City extends Building {
	
	/**
	 * When a building is constructed it is always not upgraded (a settlement)
	 * @param location The location
	 * @param pIndex The PlayerIndex of the constructing Player
	 */
	public City(VertexLocation location, PlayerIndex pIndex) {
		super(location,pIndex);
	}

	/**
	 * @return true if the building is a settlement, false if it's a city
	 */
	public boolean isSettlement() {
		return false;
	}
	
		/**
	 * @return false if the building is a settlement, true if it's a city
	 */
	public boolean isCity() {
		return true;
	}

	
	
}
