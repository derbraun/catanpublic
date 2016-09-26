package shared.models;

/**
 * Class for managing a player's development cards
 */
public class DevelopmentCardManager {

	private DevelopmentCardType yearOfPlenty;
	private DevelopmentCardType monopoly;
	private DevelopmentCardType roadBuilding;
	private MonumentCards monuments;
	private KnightCards knights;

	/**
	 * This flag is turned on when a player plays a development
	 * card and should be set to false using the reset() method
	 * at the beginning or end of the player's turn. It is used
	 * to keep track of whether or not the player has played a
	 * development card this turn.
	 */
	private boolean played;

	/**
	 * Constructor. Initializes the DevelopmentCardManager with the
	 * given DevelopmentCardType objects.
	 * 
	 * @param aPlayed whether or not the player has played a development
	 * card this turn.
	 * @param aYearOfPlenty the Year of Plenty Cards object.
	 * @param aMonopoly the Monopoly Cards object.
	 * @param aRoadBuilding the Road Building Cards object.
	 * @param aMonuments the Monument Cards object
	 * @param aKnights the Knight Cards object.
	 */
	public DevelopmentCardManager(boolean aPlayed,
			DevelopmentCardType aYearOfPlenty,
			DevelopmentCardType aMonopoly,
            DevelopmentCardType aRoadBuilding,
			MonumentCards aMonuments, KnightCards aKnights) {

	}

	public DevelopmentCardType getYearOfPlenty() {
		return yearOfPlenty;
	}

	public DevelopmentCardType getMonopoly() {
		return monopoly;
	}

	public DevelopmentCardType getRoadBuilding() {
		return roadBuilding;
	}

	public MonumentCards getMonuments() {
		return monuments;
	}

	public KnightCards getKnights() {
		return knights;
	}

	/**
	 * At the beginning of a turn, resets the `played` flag to false and
	 * sets each card type as as playable if the player has one or more
	 * of that card type.
	 * 
	 * @post the DevelopmentCardManager's "has played" flag is set to
	 * false, and any card types for which there is at least one in the
	 * player's hand is set to playable.
	 */
	public void reset() {
		
	}

}