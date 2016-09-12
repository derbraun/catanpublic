package john;



public class SoldierCardManager extends DevelopmentCardManager {

	private armySize;

	public addSoldierToArmy() {
		remove();
		armySize++;
	}

	public int getArmySize() {
		return armySize;
	}

	public boolean hasLargestArmy() {
		
	}

}