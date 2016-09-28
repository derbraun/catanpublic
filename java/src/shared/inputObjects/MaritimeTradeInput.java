package shared.inputObjects;

import shared.definitions.ResourceType;

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
	ResourceType inputResource;
	
	/**
	 * The resource the player is receiving
	 */
	ResourceType outputResource;

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
							  ResourceType inputResource, 
							  ResourceType outputResource) {
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

	public ResourceType getInputResource() {
		return inputResource;
	}

	public void setInputResource(ResourceType inputResource) {
		this.inputResource = inputResource;
	}

	public ResourceType getOutputResource() {
		return outputResource;
	}

	public void setOutputResource(ResourceType outputResource) {
		this.outputResource = outputResource;
	}
}
