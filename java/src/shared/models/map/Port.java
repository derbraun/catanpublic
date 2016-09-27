package shared.models.map;

import shared.definitions.PortType;
import shared.locations.EdgeLocation;

/**
 * Represents a Port in the Settlers of Catan map
 * @author Cory
 *
 */
public class Port {
	
	/**
	 * The edge location of this port
	 */
	private EdgeLocation location;
	
	/**
	 * The current type of port
	 */
	private PortType type;

	/**
	 * @param location
	 * @param type
	 */
	public Port(EdgeLocation location, PortType type) {
		if (location == null || type == null){
			throw new IllegalArgumentException();
		}
		this.location = location;
		this.type = type;
	}

	/**
	 * @return the location
	 */
	public EdgeLocation getLocation() {
		return location;
	}

	/**
	 * @return the type
	 */
	public PortType getType() {
		return type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Port other = (Port) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Port [location=" + location + ", type=" + type + "]";
	}
	
	
	
	
	
}
