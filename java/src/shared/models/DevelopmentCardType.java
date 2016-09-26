package shared.models;

import shared.models.exceptions.NegativeGameComponentsException;

/**
 * Class for managing a player's cards of a specific type. Contains
 * information on how many are left and whether that type is playable
 * this turn, and has methods for manipulating that data.
 */
public class DevelopmentCardType {

	protected int remaining;
	protected boolean playable;

	/**
	 * Constructor. Initializes the DevelopmentCardType with the given
	 * number of cards left and the given playable/nonplayable status
	 * 
	 * @param amount the number of cards the player has left of this
	 * type. Must be a non-negative integer.
	 * @param isPlayable whether or not the card type is playable this
	 * turn.
	 * @throws NegativeGameComponentsException if amount is negative.
	 */
	public DevelopmentCardType(int amount, boolean isPlayable) throws NegativeGameComponentsException {
		remaining = amount;
		playable = isPlayable;
	}

	/**
	 * Gets the number of cards of this type that the player has left.
	 * 
	 * @return the number of cards of this type the player has left.
	 */
	public int numLeft() {
		return remaining;
	}

	/**
	 * Checks to see if the player can play this type of card.
	 * 
	 * @return true if the player has the card and can play it this
	 * turn, false otherwise.
	 */
	public boolean canPlay() {
            return playable && remaining > 0;
	}

	/**
	 * Simulates drawing a development card by giving the player one
	 * more of this type of card
	 * 
	 * @post The player has one more of this type of card than before.
	 */
	public void draw() {
		remaining++;
	}

	/**
	 * Simulates discarding a development card by subtracting one from
	 * this player's cards of this type.
	 * 
	 * @pre The user has at least 1 of this kind of card
	 * @post The user has one less of this card than before.
	 * @throws NegativeGameComponentsException if player doesn't have a
	 * card to discard.
	 */
	public void discard() throws NegativeGameComponentsException {
		remaining--;
	}

	/**
	 * If the player has at least one of this card, sets this card type
	 * as playable. Meant to be called at the beginning of each turn.
	 * 
	 * @post If the user has at least one of this type of card, then
	 * this card type is marked as playable.
	 */
	public void reset() {
		playable = remaining > 0;
	}

}