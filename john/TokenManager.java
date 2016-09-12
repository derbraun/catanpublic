package john;

import java.util.List;

import john.Location;

/** the parent class for RoadManager and SettlementManager. Contains
 * data and functionality that the two classes have in common. Not meant
 * to be instantiated.
 */
class TokenManager {

	protected int remaining;
	protected List<Location> built;

	public TokenManager() {

	}

	/**
	 * @return the number of unused tokens.
	 */
	public int getRemaining() {
		return remaining;
	}

	/**
	 * @return a list of map locations where tokens have been placed
	 */
	public List<Location> getBuilt() {
		return built;	
	}

	/** take a token from the player's reserve, and transfer it to a
	 * location on the map.
	 * @param location the place where the token will be 'built' on the
	 * map
	 */
	public void build(Location location) {
		remaining--;
		built.add(location);
	}

}