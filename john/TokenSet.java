package john;

import john.Player;
import john.RoadManager;
import john.SettlementManager;

/** holds information about a player's settlement, city, and road tokens
 */
public class TokenSet {

	private RoadManager roads;
	private SettlementManager settlements;
	private SettlementManager cities;

	public TokenSet() {

	}

	/**
	 * @return an object that contains information about the player's
	 * roads, both those built and those still unused
	 */
	public RoadManager getRoads() {
		return roads;
	}

	/**
	 * @return an object containing information on the player's
	 * settlements, both used and unused
	 */
	public SettlementManager getSettlements() {
		return settlements;
	}

	/**
	 * @return an object containing information on the player's
	 * cities, both used and unused
	 */
	public SettlementManager getCities() {
		
	}

	/** returns and object telling how many resources a player gets when
	 * the given number is rolled.
	 * @param number the number rolled
	 * @return the an object containing information about the resources
	 * the Player gets.
	 */
	public ResourceSet getResourcesForRoll(int number) {

	}

}