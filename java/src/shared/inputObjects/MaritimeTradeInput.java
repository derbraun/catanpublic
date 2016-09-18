package shared.inputObjects;

/**
 * Holds the input parameters needed for MaritimeTrade()
 */
public class MaritimeTradeInput extends InputObject {

	/**
	 * The ID of the player that is trading
	 */
	int playerID;
	
	/**
	 * The ratio of input cards to output cards to trade
	 */
	int ratio;
	
	/**
	 * The resource the player is giving
	 */
	Resource inputResource;
	
	/**
	 * The resource the player is receiving
	 */
	Resource outputResource;

	/**
	 * Creates an instance of the MaritimeTrade input parameters object
	 * @param playerID The ID of the player that is trading
	 * @param ratio The ratio of input cards to output cards to trade
	 * @param inputResource The resource the player is giving
	 * @param outputResource The resource the player is receiving
	 * @pre 1. playerID is not null and is an existing player<br/>
	 * 		2. ratio is not null and is a valid integer 2-4<br/>
	 * 		3. inputResource is not null and is a valid resource<br/>
	 * 		4. outputResource is not null and is a valid resource
	 * @post A MaritimeTradeInput object is created
	 */
	public MaritimeTradeInput(int playerID, 
							  int ratio, 
							  Resource inputResource, 
							  Resource outputResource) {
		this.playerID = playerID;
		this.ratio = ratio;
		this.inputResource = inputResource;
		this.outputResource = outputResource;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public int getRatio() {
		return ratio;
	}

	public void setRatio(int ratio) {
		this.ratio = ratio;
	}

	public Resource getInputResource() {
		return inputResource;
	}

	public void setInputResource(Resource inputResource) {
		this.inputResource = inputResource;
	}

	public Resource getOutputResource() {
		return outputResource;
	}

	public void setOutputResource(Resource outputResource) {
		this.outputResource = outputResource;
	}
}
