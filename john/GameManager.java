package john;

import java.util.List;

import john.Game;
import john.User;
import john.Player;

/** manages all games
 */
public class GameManager {
	
	private List<Game> games;
	private List<User> users;

	public GameManager() {

	}

	/**
	 * @return a list of all games
	 */
	public List<Game> getGames() {
		return games;
	}

	/** create game and add it to the games list
	 */
	public void createGame() {

	}

	/** remove a game from the games list
	 * @param game the game to remove
	 */
	public void removeGame(Game game) {

	}

	/**
	 * @return a list of all users
	 */
	public List<User> getUsers() {
		return users;
	}

	/** add a user to the user list
	 * @param user the user to add
	 */
	public void addUser(User user) {

	}

	/** remove a user from the user list
	 * @param user the user to remove
	 */
	public void removeUser(User user) {

	}

}