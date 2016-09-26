package shared.models;

import shared.models.exceptions.NegativeGameComponentsException;

/**
 * Class for managing a player's Knight cards. Contains information on
 * how many are left and whether that type is playable this turn, and
 * has methods for manipulating that data.
 */
public class KnightCards extends DevelopmentCardType {

	private int armySize;

	/**
	 * Constructor. Initializes the KnightCards with the given number of
	 * cards left, the given playable/nonplayable status, and the given
	 * army size.
	 * 
	 * @param amount the number of cards the player has left of this
	 * type. Must be non-negative.
	 * @param isPlayable whether or not the card type is playable this
	 * turn.
	 * @param anArmySize the current size of the player's army. Must be
	 * non-negative.
	 * @throws NegativeGameComponentsException if amount or anArmySize is
	 * negative.
	 */
	public KnightCards(int amount, boolean isPlayable, int anArmySize) throws NegativeGameComponentsException  {
            super(amount, isPlayable);
            armySize = anArmySize;
	}

	public int getArmySize() {
		return armySize;
	}

	/**
	 * Simulates playing a knight card by decrementing the number of
	 * playable Knight cards by one and increasing the army size by one.
	 * 
	 * @pre Player has at least one knight card in their hand.
	 * @post Player has one less Knight card in their hand, and their
	 * army size is bigger by one knight.
	 * @throws NegativeGameComponentsException if user does not have a
	 * knight to play.
	 */
	public void moveKnightToArmy() {
		remaining--;
		armySize++;
	}

}