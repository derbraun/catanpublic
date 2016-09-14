package shared.models;

import java.util.List;
import java.util.ArrayList;

import shared.models.TokenManager;
import shared.models.Card;

/** Represents a player in a single game of Settlers of Catan. Each
 * user may play multiple games at a time, so a Player represents an
 * instance of a single user playing a single game.
 */
class Player {

	private String name;
	private String color;
	private int points;
	private TokenManager tokens;
	private ResourceManager resources;
	private DevelopmentCardManager developmentCards;

	/** Constructor
	 * @param user the User object connected to this player
	 * @param color the color the player will be represented by
	 */
	public Player(String aName, String aColor) {
		name = aName;
		color = aColor;
		points = 0;
		tokens = new TokenManager();
		resources = new ResourceManager();
		developmentCards = new DevelopmentCardManager();
	}

	/**
	 * @return the number of points the player has
	 */
	public int getPoints() {
		return points;
	}

	/** gives the player a point
	 */
	public void addPoint() {
		points++;
	}

	/** adds the specified number of points to the player's score
	 * @param numPoints the number of points to add
	 */
	public void addPoints(int numPoints) {
		points += numPoints;
	}

	/** takes away one point from the player
	 */
	public void removePoint() {
		points--;
	}

	/** removes the specified number of points from the player's score
	 * @param numPoints the number of points to remove
	 */
	public void removePoints(int numPoints) {
		points -= numPoints;
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
		return name;
	}

	/**
	 * @return an object containing information about the player's
	 * tokens
	 */
	public TokenManager getTokens() {
		return tokens;
	}

	/**
	 * @return an object that manages resources for the player
	 */
	public ResourceManager getResources() {
		return resources;
	}

	/**
	 * @return an object that manages the player's development cards
	 */
	public DevelopmentCardManager getDevelopmentCards() {
		return developmentCards;
	}

	/**
	 * @return true if the player has a road token and can afford to use
	 * it, false otherwise
	 */
	public boolean canBuyRoad() {
		return resources.canAffordRoad() && tokens.hasRoadsLeft();
	}

	/**
	 * @return true if the player has a settlement token and can afford
	 * to use it, false otherwise
	 */
	public boolean canBuySettlement() {
		return resources.canAffordSettlement && tokens.hasSettlementsLeft();
	}

	/**
	 * @return true if the player has a city token and can afford to use
	 * it, false otherwise
	 */
	public boolean canBuyCity() {
		return resources.canAffordCity() && tokens.hasCitiesLeft();
	}

	/**
	 * @return true if the player can afford a development card, false
	 * otherwise
	 */
	public boolean canBuyDevelopmentCard() {
		return resources.canAffordDevelopmentCard();
	}

}