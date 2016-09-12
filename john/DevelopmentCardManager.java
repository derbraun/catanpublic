package john;

import john.Player;

public class DevelopmentCardManager {
	
	private int numYearOfPlenty;
	private int numMonopoly;
	private int numRoadBuilding;
	private int numMonument;
	private int numSoldiers;
	private Player player;

	public DevelopmentCardManager() {

	}

	public int getYearOfPlentyCount() {
		return numYearOfPlenty;
	}

	public void addYearOfPlenty() {
		numYearOfPlenty++;
	}

	public void removeYearOfPlenty() {
		numYearOfPlenty--;
	}

	public int getMonopolyCount() {
		return numMonopoly;
	}

	public void addMonopoly() {
		numMonopoly++
	}

	public void removeMonopoly() {
		numMonopoly--;
	}

	public int getRoadBuildingCount() {
		return numRoadBuilding;
	}

	public void addRoadBuilding() {
		numRoadBuilding++;
	}

	public void removeRoadBuilding() {
		numRoadBuilding--;
	}

	public int getMonumentCount() {
		return numMonument;
	}

	public void addMonument() {
		numMonument++;
	}

	public void removeMonument() {
		numMonument--;
	}

	public int getSoldierCount() {
		return numSoldiers;
	}

	public void addSoldier() {
		numSoldiers++;
	}

	public void removeSoldier() {
		numSoldiers--;
	}

	public boolean canPlayYearOfPlenty() {

	}

	public boolean canPlayMonopoly() {

	}

	public boolean canPlayRoadBuilding() {

	}

	public boolean canPlayMonument() {

	}

	public boolean canPlaySoldier() {

	}

}