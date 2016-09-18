package shared.inputObjects;

/**
 * Holds the input parameters needed for SetCommandsForGame()
 */
public class SetCommandsForGameInput extends InputObject {

	/**
	 * The userName of the player
	 */
	String userName;
	
	/**
	 * The password of the player
	 */
	String password;

	/**
	 * Creates an instance of the SetCommandsForGame input parameters object
	 * @param userName The userName of the player
	 * @param password The password of the player
	 * @pre userName is not null and password is not null
	 * @post A SetCommandsForGameInput object is created
	 */
	public SetCommandsForGameInput(String userName, 
						  String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
