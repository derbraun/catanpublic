package john;

import john.DevelopmentCardManager;

/** contains information about a player's development cards
 */
public class DevelopmentCardSet {
	
	private DevelopmentCardManager yearOfPlenty;
	private DevelopmentCardManager monopoly;
	private DevelopmentCardManager roadBuilding;
	private DevelopmentCardManager monument;
	private SoldierCardManager soldier;
	private boolean played;

	public DevelopmentCardSet() {

	}


	public DevelopmentCardManager getYearOfPlenty() {
		return yearOfPlenty;
	}

	public DevelopmentCardManager getMonopoly() {
		return monopoly;
	}

	public DevelopmentCardManager getRoadBuilding() {
		return roadBuilding;
	}

	public DevelopmentCardManager getMonument() {
		return monument;
	}

	public SoldierCardManager getSoldier() {
		return soldier;
	}

	public boolean hasPlayed() {

	}

	public boolean canPlay() {

	}

}