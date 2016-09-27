package shared.models;

import com.google.gson.JsonObject;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import shared.models.exceptions.ColorParseException;
import shared.models.exceptions.JsonStructureException;
import shared.models.exceptions.NegativeGameComponentsException;

/**
 * Represents a player in a single game of Settlers of Catan. Each user may play
 * multiple games at a time; a Player represents an instance of a single user
 * playing a single game.
 */
public class Player {

	private String name;
	private Color color;
	private int points;
	private TokenManager tokens;
	private ResourceManager resources;
	private DevelopmentCardManager developmentCards;

	/**
	 * Constructor. Creates a player in a just-starting-the-game state.
	 *
	 * @param user the User object connected to this player
	 * @param color the color the player will be represented by. The color must
	 * be a String representing a hexidecimal number.
	 * @throws ColorParseException if aColor is not a hexidecimal
	 * representation of a color.
	 */
	public Player(String aName, Color aColor) throws ColorParseException,
			NegativeGameComponentsException {
		name = aName;
		color = aColor;
		points = 0;
		tokens = new TokenManager();
		resources = new ResourceManager();
		developmentCards = new DevelopmentCardManager();
		
		DevelopmentCardType yearOfPlenty = new DevelopmentCardType(0, false);
		DevelopmentCardType monopoly = new DevelopmentCardType(0, false);
		DevelopmentCardType roadBuilding = new DevelopmentCardType(0, false);
		MonumentCards monuments = new MonumentCards(0);
		KnightCards knights = new KnightCards(0, false, 0);
		developmentCards = new DevelopmentCardManager(false, yearOfPlenty,
				monopoly, roadBuilding, monuments, knights);
	}

	/**
	 * Constructor. Constructs a Player object from the JSON representation sent
	 * by the server.
	 *
	 * @param json The JSON object to initialize the Player from. Must
	 * be of the pre-specified format of player objects the server is
	 * supposed to send.
	 * @throws JsonStructureException if the json structure is
	 * incorrect.
	 */
	public Player(JsonObject json) throws JsonStructureException,
			ColorParseException, NotEnoughVictoryPointsException,
			NegativeGameComponentsException {
		name = (String)json.get("name").getAsString();
		String colorString = json.get("color").getAsString();
		color = Color.getColor(colorString);
		if(color == null) throw new ColorParseException();
		points = json.get("points").getAsInt();
		if(points < 0) throw new NotEnoughVictoryPointsException();
		developmentCards = new DevelopmentCardManager(json);
		tokens = new TokenManager(json);
		try {
			JsonObject resourcesJson = json.get("resources").getAsJsonObject();
			resources = new ResourceManager(resourcesJson);
		} catch(ClassCastException | IllegalStateException ex) {
			throw new JsonStructureException(ex);
		}
	}

	public int getPoints() {
		return points;
	}

	/**
	 * Gives the player a point.
	 * 
	 * @post The player has one more point than before.
	 */
	public void addPoint() {
		points++;
	}

	/**
	 * Adds the specified number of points to the player's score.
	 *
	 * @param numPoints the number of points to add. Must be
	 * non-negative.
	 * @post The player has `numPoints` more points than before.
	 * @throws NegativeGameComponentsException if numPoints is
	 * negative.
	 */
	public void addPoints(int numPoints) throws NegativeGameComponentsException {
		points += numPoints;
	}

	/**
	 * Takes away one point from the player.
	 *
	 * @pre The player has at least one point.
	 * @post The player has one less point than before.
	 * @throws NegativeGameComponentsException if player doesn't
	 * have any points to remove.
	 */
	public void removePoint() throws NegativeGameComponentsException {
		points--;
	}

	/**
	 * Removes the specified number of points from the player's score.
	 *
	 * @param numPoints the number of points to remove. Must be
	 * non-negative.
	 * @pre The player has at least `numPoints` points.
	 * @post The player has `numPoints` less points than before.
	 * @throws NegativeGameComponentsException if numPoints is negative
	 * or player already has less than numPoints.
	 */
	public void removePoints(int numPoints) throws NegativeGameComponentsException {
		points -= numPoints;
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public TokenManager getTokens() {
		return tokens;
	}

	public ResourceManager getResources() {
		return resources;
	}

	public DevelopmentCardManager getDevelopmentCards() {
		return developmentCards;
	}

	/**
	 * Checks to see if the player can buy a road.
	 *
	 * @return true if the player has a road token and can afford to use it,
	 * false otherwise
	 */
	public boolean canBuyRoad() {
		return resources.canAffordRoad() && tokens.getRoads().hasAny();
	}

	/**
	 * Checks to see if the player can buy a settlement.
	 *
	 * @return true if the player has a settlement token and can afford to use
	 * it, false otherwise
	 */
	public boolean canBuySettlement() {
		return resources.canAffordSettlement()
				&& tokens.getSettlements().hasAny();
	}

	/**
	 * Checks to see if the player can buy a city
	 *
	 * @return true if the player has a city token and can afford to use it,
	 * false otherwise
	 */
	public boolean canBuyCity() {
		return resources.canAffordCity() && tokens.getCities().hasAny();
	}

	/**
	 * Checks to see if the player can buy a development card
	 *
	 * @return true if the player can afford a development card, false otherwise
	 */
	public boolean canBuyDevelopmentCard() {
		return resources.canAffordDevelopmentCard();
	}

}
