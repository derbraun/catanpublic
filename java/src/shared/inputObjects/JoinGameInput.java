package shared.inputObjects;

import shared.definitions.CatanColor;

/**
 * Holds the input parameters needed for JoinGame()
 */
public class JoinGameInput extends InputObject {

	/**
	 * The player's userName
	 */
	String userName;
	
	/**
	 * The player's password
	 */
	String password;
	
	/**
	 * The ID of the game to join
	 */
	int gameID;
	
	/**
	 * The color of the joining player
	 */
	CatanColor playerColor;

	/**
	 * Creates an instance of the JoinGame input parameters object
	 * @param userName The name of the player joining
	 * @param password The password of the player joining
	 * @param gameID The ID of the game to join
	 * @param playerColor The color of the player joining
	 * @pre userName is not null, password is not null, gameID is a valid existing game, and playerColor is not null and is a valid color
	 * @post A JoinGameInput object is created
	 */
	public JoinGameInput(String userName,
						 String password, 
						 int gameID, 
						 CatanColor playerColor) {
		this.userName = userName;
		this.password = password;
		this.gameID = gameID;
		this.playerColor = playerColor;
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

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public CatanColor getPlayerColor() {
		return playerColor;
	}

	public void setPlayerColor(CatanColor playerColor) {
		this.playerColor = playerColor;
	}
}
