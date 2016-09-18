package shared.inputObjects;

public class AddAIPlayerInput extends InputObject {

	/**
	 * The userName of the player
	 */
	String userName;
	
	/**
	 * The password of the player
	 */
	String password;
	
	/**
	 * The type of AI to add
	 */
	String AIType;

	/**
	 * Creates an instance of the AddAIPlayer input parameters object
	 * @param userName The userName of the player
	 * @param password The password of the player
	 * @param AIType The type of AI to add
	 * @pre userName is not null and password is not null, the AIType is a valid type
	 * @post An AddAIPlayerInput object is created
	 */
	public AddAIPlayerInput(String userName, 
						    String password,
						    String AIType) {
		this.userName = userName;
		this.password = password;
		this.AIType = AIType;
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

	public String getAIType() {
		return AIType;
	}

	public void setAIType(String aIType) {
		AIType = aIType;
	}
}
