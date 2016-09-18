package shared.inputObjects;

/**
 * Holds the input parameters needed for LoginUser()
 */
public class LoginUserInput extends InputObject {
	
	/**
	 * The user's username
	 */
	String userName;
	
	/**
	 * The user's password
	 */
	String password;

	/**
	 * Creates an instance of the LoginUser input parameters object
	 * @param userID The user's username
	 * @param password The user's password
	 * @pre userName and password are not null
	 * @post A LoginUserInput object is created
	 */
	public LoginUserInput(String userName,
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
