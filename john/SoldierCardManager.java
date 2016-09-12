package john;

public class SoldierCardManager extends DevelopmentCardManager {

	private int armySize;

	public void addSoldierToArmy() {
		remove();
		armySize++;
	}

	public int getArmySize() {
		return armySize;
	}

	public boolean hasLargestArmy() {
		
	}

}