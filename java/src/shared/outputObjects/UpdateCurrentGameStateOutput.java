package shared.outputObjects;

import com.google.gson.JsonObject;

/**
 * Holds the output information needed for UpdateCurrentGameState()
 */
public class UpdateCurrentGameStateOutput extends OutputObject {

	/**
	 * Indicates whether or not the operation was successful
	 */
	String success;
	
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
		this.success = "TRUE";
	}
	
	/**
	 * An overload constructor to handle failed operations
	 * @param success Indicates whether or not the operation was successful
	 */
	public UpdateCurrentGameStateOutput(String success) {
		
		this.success = success;
	}
	
	public JsonObject getJsonResponse() {
		return jsonResponse;
	}

	public void setJsonResponse(JsonObject jsonResponse) {
		this.jsonResponse = jsonResponse;
	}
	
	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}
	
	/**
	 * Indicates whether the operation was successful or not
	 */
	@Override
	public boolean Failed() {
		// TODO Auto-generated method stub
		return success.equals("FALSE") || success.equals("FAILED");
	}

}
