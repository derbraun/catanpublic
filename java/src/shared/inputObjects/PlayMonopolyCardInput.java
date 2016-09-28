package shared.inputObjects;

import shared.definitions.ResourceType;

/**
 * Holds the input parameters needed for PlayMonopolyCard()
 */
public class PlayMonopolyCardInput extends InputObject {

	/**
	 * The ID of the player playing the monopoly card
	 */
	int playerID;
	
	/**
	 * The resource to be taken from all other players
	 */
	ResourceType resource;

	/**
	 * Creates an instance of the PlayMonopolyCard input parameters object
	 * @param playerID The ID of the player playing the monopoly card
	 * @param resource The resource to be taken from all other players
	 * @pre playerID is not null and is an existing player and resource is not null and is a valid resource
	 */
	public PlayMonopolyCardInput(int playerID, 
								 ResourceType resource) {
		this.playerID = playerID;
		this.resource = resource;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public ResourceType getResource() {
		return resource;
	}

	public void setResource(ResourceType resource) {
		this.resource = resource;
	}
}
