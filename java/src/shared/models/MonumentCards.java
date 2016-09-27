package shared.models;

import com.google.gson.JsonObject;
import shared.models.exceptions.JsonStructureException;
import shared.models.exceptions.NegativeGameComponentsException;

/**
 * Class for managing a player's Monument cards. Contains information on
 * how many are left and whether that type is playable this turn, and
 * has methods for manipulating that data.
 */
public class MonumentCards extends DevelopmentCardType {

	/**
	 * Constructor. Initializes the MonumentCards with the given number
	 * of cards left and the given playable/nonplayable status
	 * 
	 * @param amount the number of cards the player has left of this
	 * type. Must be non-negative.
	 * @param isPlayable whether or not the card type is playable this
	 * turn.
	 * @throws NegativeGameComponentsException if amount is negative.
	 */
	public MonumentCards(int amount) throws NegativeGameComponentsException {
            super(amount, true);
			if(amount < 0) throw new NegativeGameComponentsException();
	}
	
	public MonumentCards() throws NegativeGameComponentsException {
		super();
	}
	
	public MonumentCards(JsonObject playerJson) throws JsonStructureException {
		super(playerJson, "monument");
	}

	/**
	 * Checks to see if the player can play this type of card. Unlike
	 * with most DevelopmentCardTypes, the MonumentCards.canPlay() check
	 * only requires that the player has at least one Monument card, and
	 * does not require that the player had it at the beginning of their
	 * turn.
	 * 
	 * @return true if the player has at least one Monument card, false
	 * otherwise.
	 */
	@Override
	public boolean canPlay() {
		return numLeft() >= 1;
	}

}