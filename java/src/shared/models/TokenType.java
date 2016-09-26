package shared.models;

import shared.models.exceptions.NegativeGameComponentsException;

/**
 * Contains information on the number of a certain type of token a
 * player has.
 */
public class TokenType {

	private int remaining;

	/**
	 * Constructor. Initializes the TokenType with the given amount
	 * remaining.
	 * 
	 * @param amount the number left of the token type. Must be a
	 * non-negative integer.
	 * @throws NegativeGameComponentsException if amount is negative.
	 */
	public TokenType(int amount) throws NegativeGameComponentsException {
		if(amount < 0) throw new NegativeGameComponentsException();
		remaining = amount;
	}

	/**
	 * Gets the number of tokens the player has left.
	 * 
	 * @return the number of tokens that are left of this type for the
	 * Player that owns this set of tokens.
	 */
	int numLeft() {
		return remaining;
	}

	/**
	 * Removes one token of this token type from the player's pile
	 * (this is done when a player builds one of this type of token).
	 * 
	 * @pre There must be at least one of this type of token left.
	 * @post The player has one less of this type of token than before.
	 * @throws NegativeGameComponentsException if the player does not
	 * have any of this token type.
	 */
	void remove() throws NegativeGameComponentsException {
		if(!hasAny()) throw new NegativeGameComponentsException();
		remaining--;
	}

	/**
	 * Checks to see if the player has any of this token left to play.
	 * 
	 * @return true if there are any tokens of this type remaining in
	 * the player's token pile, false otherwise.
	 */
	boolean hasAny() {
		return numLeft() != 0;
	}

}