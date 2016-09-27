package shared.models.map;

import shared.models.exceptions.BuildingNotUpgradableException;

import shared.definitions.PlayerIndex;
import shared.locations.VertexLocation;

/**
 * Represents a settlement or a city that is placed on 
 * the Settlers of Catan map. 
 * @author Cory
 *
 */
public class Building {

	/** Where the building is located */
	private VertexLocation location;
	/** Who owns the building */
	private PlayerIndex pIndex;
	/** false = settlement, true = city */
	private boolean isUpgraded = false;

	
	/**
	 * When a building is constructed it is always not upgraded (a settlement)
	 * @param location The location
	 * @param pIndex The PlayerIndex of the constructing Player
	 */
	public Building(VertexLocation location, PlayerIndex pIndex) {
		super();
		
		this.location = location;
		this.pIndex = pIndex;
		this.isUpgraded = false;
	}

	/**
	 * @return the location
	 */
	public VertexLocation getLocation() {
		return location;
	}

	/**
	 * @return the PlayerIndex of the player that owns this building
	 */
	public PlayerIndex getPlayerIndex() {
		return pIndex;
	}

	/**
	 * @return true if the building is a settlement, false if it's a city
	 */
	public boolean isSettlement(){
		return !isUpgraded;
	}
	
	/**
	 * @return false if the building is a settlement, true if it's a city
	 */
	public boolean isCity(){
		return isUpgraded;
	}

	/**
	 * Upgrade the building to be a city
	 * 
	 * @pre isUpgraded = false
	 * 
	 * @post isUpgraded = true
	 * 
	 */
	public void upgradeToCity() throws BuildingNotUpgradableException{
		if (isUpgraded){
			throw new BuildingNotUpgradableException();
		}
		this.isUpgraded = true;
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isUpgraded ? 1231 : 1237);
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
		Building other = (Building) obj;
		if (isUpgraded != other.isUpgraded)
			return false;
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
		return "Building [location=" + location + ", pIndex=" + pIndex + ", isCity=" + isUpgraded + "]";
	}
	
	
	
}
