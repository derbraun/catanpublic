package shared.outputObjects;

/**
 * Holds the output parameters needed for GetCommandsForGame()
 */
public class GetCommandsForGameOutput extends OutputObject {

	/**
	 * Indicates whether or not the operation was successful
	 */
	String success;
	
	/**
	 * Creates an instance of the GetCommandsForGame output parameters object
	 * @pre none
	 * @post An GetCommandsForGameOutput object is created
	 */
	public GetCommandsForGameOutput() {
		this.success = "TRUE";
	}
	
	/**
	 * An overload constructor to handle failed operations
	 * @param success Indicates whether or not the operation was successful
	 */
	public GetCommandsForGameOutput(String success) {
		
		this.success = success;
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
