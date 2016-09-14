package shared.models;

/** class for managing a player's development cards
 */
class DevelopmentCardManager {

	private int yearOfPlenty;
	private boolean yearOfPlentyPlayable;
	private int monopoly;
	private boolean monopolyPlayable;
	private int roadBuilding;
	private boolean roadBuildingPlayable;
	private int monument;
	private int knights;
	private boolean knightsPlayable;
	private int armySize;

	/** This flag is turned on when a player plays a development
	 * card and should be set to false using the reset() method
	 * at the beginning or end of the player's turn. It is used
	 * to keep track of whether or not the player has played a
	 * development card this turn.
	 */
	private boolean played;

	/** Constructor. Starts the player out with zero development cards.
	 */
	public DevelopmentCardManager() {
		yearOfPlenty = 0;
		yearOfPlentyPlayable = true;
		monopoly = 0;
		roadBuilding = 0;
		monument = 0;
		knights = 0;
		armySize = 0;
		played = false;
	}

	/**
	 * @return the number of Year of Plenty cards the player has
	 */
	public int getNumYearOfPlenty() {
		return yearOfPlenty;
	}

	/**
	 * @return true if the player had at least one Year of Plenty Card
	 * at the beginning of the turn and has not played a development card
	 * this turn, false otherwise
	 */
	public boolean canPlayYearOfPlenty() {
		return knightsPlayable && !played;
	}

	/** have the player draw a Year of Plenty card
	 */
	public void drawYearOfPlenty() {
		yearOfPlenty++;
	}

	/** have a player discard a Year of Plenty card
	 */
	public void discardYearOfPlenty() {
		yearOfPlenty--;
		played = true;
	}

	/**
	 * @return the number of Monopoly cards the player has
	 */
	public int getNumMonopoly() {
		return monopoly;
	}

	/**
	 * @return true if the player had at least one Monopoly card
	 * at the beginning of the turn and has not played a development card
	 * this turn, false otherwise
	 */
	public boolean canPlayMonopoly() {
		return monopolyPlayable && !played;
	}

	/** have the player draw a Monopoly card
	 */
	public void drawMonopoly() {
		monopoly++;
	}

	/** have a player discard a Monopoly card
	 */
	public void discardMonopoly() {
		monopoly--;
		played = true;
	}

	/**
	 * @return the number of Road Building cards the player has
	 */
	public int getNumRoadBuilding() {
		return roadBuilding;
	}

	/**
	 * @return true if the player had at least one Road Building card
	 * at the beginning of the turn and has not played a development card
	 * this turn, false otherwise
	 */
	public boolean canPlayRoadBuilding() {
		return roadBuildingPlayable && !played;
	}

	/** have the player draw a Road Building card
	 */
	public void drawRoadBuilding() {
		roadBuilding++;
	}

	/** have a player discard a Road Building card
	 */
	public void discardRoadBuilding() {
		roadBuilding--;
		played = true;
	}

	/**
	 * @return the number of Monument cards the player has
	 */
	public int getNumMonument() {
		return monument;
	}

	/**
	 * @return true if the player has at least one Monument card
	 * and has not played a development card this turn, false otherwise
	 */
	public boolean canPlayMonument() {
		return monument > 0 && !played;
	}

	/** have the player draw a Monument card
	 */
	public void drawMonument() {
		monument++;
	}

	/** have a player discard a Monument card
	 */
	public void discardMonument() {
		monument--;
		played = true;
	}

	/**
	 * @return the number of Knight cards the player has
	 */
	public int getNumKnights() {
		return knights;
	}

	/**
	 * @return true if the player had at least one Knight card
	 * at the beginning of the turn and has not played a development
	 * card this turn, false otherwise
	 */
	public void canPlayKnight() {
		return knightsPlayable && !played;
	}

	/** have the player draw a Knight card
	 */
	public void drawKnight() {
		knights++;
	}

	/** move a knight card from a player's hand to their army
	 */
	public void moveKnightToArmy() {
		knights--;
		armySize++;
		played = true;
	}

	/**
	 * @return the number of knights in the player's army
	 */
	public int getArmySize() {
		return armySize;
	}

	/** resets the `played` flag to false and set booleans for number of
	 * cards at the beginning of the turn
	 */
	public void reset() {
		played = false;
		yearOfPlentyPlayable = yearOfPlenty ? true : false;
		monopolyPlayable = monopoly ? true : false;
		roadBuildingPlayable = roadBuilding ? true : false;
		knightsPlayable = knights ? true : false;
	}

}