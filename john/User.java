package john;

import java.util.List;

import john.Player;
import john.Game;

/** represents an account of a person using the web app. One User
 * account may be associated with multiple Player objects. Each user has
 * one player per game the user is playing in.
 */
class User {

	private List<Player> players;
	private String name;

	public User(String name, String password) {

	}

	/** sets the user's username
	 * @param aName the new name
	 */
	public void setName(String aName) {
		name = aName;
	}

	/**
	 * @return the user's username
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the player objects associated with the user
	 */
	public List<Player> getPlayers() {
		return players;
	}

}