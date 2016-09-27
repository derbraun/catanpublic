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
		if (location == null || pIndex == null){
			throw new IllegalArgumentException();
		}
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((pIndex == null) ? 0 : pIndex.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Road other = (Road) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (pIndex != other.pIndex)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Road [location=" + location + ", pIndex=" + pIndex + "]";
	}
	
	
	
}
