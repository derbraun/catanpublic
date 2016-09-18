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
	public EdgeLocation location;
	
	/**
	 * The current type of port
	 */
	public PortType type;

	/**
	 * @param location
	 * @param type
	 */
	public Port(EdgeLocation location, PortType type) {
		this.location = location;
		this.type = type;
	}
	
	
}
