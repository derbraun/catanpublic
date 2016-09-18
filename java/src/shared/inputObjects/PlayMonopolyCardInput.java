package shared.inputObjects;

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
	Resource resource;

	/**
	 * Creates an instance of the PlayMonopolyCard input parameters object
	 * @param playerID The ID of the player playing the monopoly card
	 * @param resource The resource to be taken from all other players
	 * @pre playerID is not null and is an existing player and resource is not null and is a valid resource
	 */
	public PlayMonopolyCardInput(int playerID, 
								 Resource resource) {
		this.playerID = playerID;
		this.resource = resource;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}
}
