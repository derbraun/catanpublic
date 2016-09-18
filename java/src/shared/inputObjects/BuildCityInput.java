package shared.inputObjects;

import shared.locations.VertexLocation;

/**
 * Holds the input parameters for BuildCity()
 */
public class BuildCityInput extends InputObject {

	/**
	 * The ID of the player to build the city
	 */
	int playerID;
	
	/**
	 * The location for the city to be placed
	 */
	VertexLocation vertexLocation;

	/**
	 * Creates an instance of the BuildCity input parameters object
	 * @param playerID The ID of the player to build the city
	 * @param vertexLocation The location for the city to be place
	 * @pre playerID is not null and is an existing player and vertexLocation is not null and is a valid VertexLocation
	 * @post A BuildCityInput object is created
	 */
	public BuildCityInput(int playerID,
								VertexLocation vertexLocation) {
		this.playerID = playerID;
		this.vertexLocation = vertexLocation;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public VertexLocation getVertexLocation() {
		return vertexLocation;
	}

	public void setVertexLocation(VertexLocation vertexLocation) {
		this.vertexLocation = vertexLocation;
	}
}
