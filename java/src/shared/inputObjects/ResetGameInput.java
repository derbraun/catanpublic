package shared.inputObjects;

/**
 * Holds the input parameters needed for ResetGame()
 */
public class ResetGameInput extends InputObject {

	/**
	 * The userName of the player
	 */
	String userName;
	
	/**
	 * The password of the player
	 */
	String password;

	/**
	 * Creates an instance of the ResetGame input parameters object
	 * @param userName The userName of the player
	 * @param password The password of the player
	 * @pre userName is not null and password is not null
	 * @post A ResetGameInput object is created
	 */
	public ResetGameInput(String userName, 
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
