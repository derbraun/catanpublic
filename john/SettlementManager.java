package john;

import java.util.List;

import john.TokenManager;

/** manages a player's settlements and cities, both used and unused
 */
class SettlementManager extends TokenManager {

	protected List<Vertex> built;

 	/** returns an object containing information about resources a
 	 * player should get if the given number is rolled
 	 * @param number the number rolled
 	 * @return a ResourceSet containing information about the resources
 	 * the player should get
 	 */
	public ResourceSet getResourcesForRoll(int number) {
		
	}

}