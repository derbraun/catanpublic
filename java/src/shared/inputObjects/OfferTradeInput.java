package shared.inputObjects;

/**
 * Holds the input parameters needed for OfferTrade()
 */
public class OfferTradeInput extends InputObject {

	/**
	 * The ID of the player offering the trade
	 */
	int playerID;
	
	/**
	 * The cards the person is offering and wanting to receive (as negative numbers)
	 */
	ResourceHand offer;
	
	/**
	 * The player receiving the offer
	 */
	PlayerIndex receiver;

	/**
	 * Creates an instance of the OfferTrade input parameters object
	 * @param playerID The ID of the player offering the trade
	 * @param offer The cards the person is offering and wanting to receive (as negative numbers)
	 * @param receiver The player receiving the offer
	 * @pre 1. playerID is not null and is an existing player<br/>
	 * 		2. offer is not null and contains valid cards<br/>
	 * 		3. receiver is not null and is an existing player other than the player offering the trade
	 * @post An OfferTradeInput object is created
	 */
	public OfferTradeInput(int playerID, 
						   ResourceHand offer, 
						   PlayerIndex receiver) {
		this.playerID = playerID;
		this.offer = offer;
		this.receiver = receiver;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public ResourceHand getOffer() {
		return offer;
	}

	public void setOffer(ResourceHand offer) {
		this.offer = offer;
	}

	public PlayerIndex getReceiver() {
		return receiver;
	}

	public void setReceiver(PlayerIndex receiver) {
		this.receiver = receiver;
	}
}
