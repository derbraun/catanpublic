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
	int receiverID;

	/**
	 * Creates an instance of the OfferTrade input parameters object
	 * @param playerID The ID of the player offering the trade
	 * @param offer The cards the person is offering and wanting to receive (as negative numbers)
	 * @param receiverID The player receiving the offer
	 * @pre 1. playerID is not null and is an existing player<br/>
	 * 		2. offer is not null and contains valid cards<br/>
	 * 		3. receiverID is not null and is an existing player other than the player offering the trade
	 * @post An OfferTradeInput object is created
	 */
	public OfferTradeInput(int playerID, 
						   ResourceHand offer, 
						   int receiverID) {
		this.playerID = playerID;
		this.offer = offer;
		this.receiverID = receiverID;
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

	public int getReceiverID() {
		return receiverID;
	}

	public void setReceiverID(int receiverID) {
		this.receiverID = receiverID;
	}
}
