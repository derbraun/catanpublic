package john;

import java.util.List;

import john.Player;
import john.Game;

class User {

	private List<Player> players;
	private String name;

	public User(String name, String password) {

	}

	public void setName(String aName) {
		name = aName;
	}

	public String getName() {
		return name;
	}

	public List<Player> getPlayers() {
		return players;
	}

}