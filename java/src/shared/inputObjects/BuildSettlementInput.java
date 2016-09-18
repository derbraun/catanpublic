package shared.inputObjects;

import shared.locations.VertexLocation;

/**
 * Holds the input parameters needed for BuildSettlement()
 */
public class BuildSettlementInput extends InputObject {
	
	/**
	 * The ID of the player to build the settlement
	 */
	int playerID;
	
	/**
	 * Indicates whether the piece is free or requires resources
	 */
	boolean isFree;
	
	/**
	 * The location for the settlement to be placed
	 */
	VertexLocation vertexLocation;

	/**
	 * Creates an instance of the BuildSettlement input parameters object
	 * @param playerID The ID of the player to build the settlement
	 * @param isFree Indicates whether the piece is free or requires resources
	 * @param vertexLocation The location for the settlement to be place
	 * @pre 1. playerID is not null and is an existing player<br/>
	 * 		2. isFree is a valid boolean value<br/>
	 * 		3. vertexLocation is not null and is a valid VertexLocation
	 * @post A BuildSettlementInput object is created
	 */
	public BuildSettlementInput(int playerID, 
								boolean isFree, 
								VertexLocation vertexLocation) {
		this.playerID = playerID;
		this.isFree = isFree;
		this.vertexLocation = vertexLocation;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public VertexLocation getVertexLocation() {
		return vertexLocation;
	}

	public void setVertexLocation(VertexLocation vertexLocation) {
		this.vertexLocation = vertexLocation;
	}
}
