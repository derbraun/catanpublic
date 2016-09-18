package shared.inputObjects;

/**
 * Holds the input parameters needed for DiscardCards()
 */
public class DiscardCardsInput extends InputObject {
	
	/**
	 * The ID of the player to discard cards
	 */
	int playerID;
	
	/**
	 * The specific cards to be discarded
	 */
	ResourceHand discardedCards;

	/**
	 * Creates an instance of the DiscardCards input parameters object
	 * @param playerID The ID of the player to discard cards
	 * @param discardedCards The specific cards to be discarded
	 * @pre playerID is not null and is an existing player, and discardedCards is not null and contains valid cards
	 * @post A DiscardCardsInput object is created
	 */
	public DiscardCardsInput(int playerID, 
							 ResourceHand discardedCards) {
		this.playerID = playerID;
		this.discardedCards = discardedCards;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public ResourceHand getDiscardedCards() {
		return discardedCards;
	}

	public void setDiscardedCards(ResourceHand discardedCards) {
		this.discardedCards = discardedCards;
	}

}
