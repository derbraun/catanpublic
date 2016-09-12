package john;

import String;

import john.Game;
import john.TokenManager;
import john.DevelopmentCardSet;
import john.ResourceSet;
import john.User;

/** Represents a player in a single game of Settlers of Catan. Each
 * user may play multiple games at a time, so a Player represents an
 * instance of a single user playing a single game.
 */
public class Player {

	private String color;
	private TokenSet tokens;
	private DevelopmentCardSet developmentCards;
	private ResourceSet resources;
	private User user;

	/** Constructor
	 * @param user the User object connected to this player
	 * @param color the color the player will be represented by
	 */
	public Player(User user, String color) {

	}

	/**
	 * @return the Player's color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @return the name of the User object associated with this Player
	 */
	public String getName() {

	}

	/**
	 * @return an object containing information about the player's
	 * tokens
	 */
	public TokenManager getTokens() {
		return tokens;
	}

	/**
	 * @return an object containing information about the player's
	 * development cards
	 */
	public DevelopmentCardSet getDevelopmentCards() {
		return developmentCards;
	}

	/**
	 * @return an object containing information about the player's
	 * resources.
	 */
	public ResourceSet getResourceSet() {
		return resources;
	}

	/**
	 * @return the User object associated with this Player object
	 */
	public User getUser() {
		return user;
	}

}