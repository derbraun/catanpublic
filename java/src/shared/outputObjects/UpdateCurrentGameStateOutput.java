package shared.outputObjects;

/**
 * Holds the output information needed for UpdateCurrentGameState()
 */
public class UpdateCurrentGameStateOutput extends OutputObject {

	/**
	 * The updated model in JSON form
	 */
	JsonObject jsonResponse;
	
	/**
	 * Creates an instance of the UpdateCurrentGameState output parameters object
	 * @param jsonResponse The updated model in JSON form
	 * @pre jsonResponse is not null
	 * @post An UpdateCurrentGameStateOutput object is created
	 */
	public UpdateCurrentGameStateOutput(JsonObject jsonResponse) {
		this.jsonResponse = jsonResponse;
	}
	
	public JsonObject getJsonResponse() {
		return jsonResponse;
	}

	public void setJsonResponse(JsonObject jsonResponse) {
		this.jsonResponse = jsonResponse;
	}

	/**
	 * Indicates whether the operation was successful or not
	 */
	@Override
	public boolean Failed() {
		// TODO Auto-generated method stub
		return false;
	}

}
