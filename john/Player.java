package john;

import com.google.gson.JsonObject;

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

	private User user;
	private String color;
	private PointManager points;
	private TokenSet tokens;
	private List<Card> cards

	/** Constructor
	 * @param user the User object connected to this player
	 * @param color the color the player will be represented by
	 */
	public Player(User aUser, String aColor) {
		user = aUser;
		color = aColor;
		points = new PointManager();
		tokens = new TokenManager();
		cards = new ArrayList<Card>();
	}

	/**
	 * @return an object containing information on points and functions
	 * for changing the player's points
	 */
	public PointManager getPoints() {
		return points;
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
		return user.getName();
	}

	/**
	 * @return an object containing information about the player's
	 * tokens
	 */
	public TokenManager getTokens() {
		return tokens;
	}

	/**
	 * @return a Collection containing the player's cards
	 */
	public List<Card> getCards() {
		return cards;
	}

	/**
	 * @return the User object associated with this Player object
	 */
	public User getUser() {
		return user;
	}

}