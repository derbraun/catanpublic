package shared.models;

import shared.models.exceptions.NegativeGameComponentsException;

/**
 * Holds information about a player's settlement, city, and road tokens
 */
public class TokenManager {

	private TokenType roads;
	private TokenType settlements;
	private TokenType cities;

	/**
	 * Constructor. Initializes the TokenManager with the given number
	 * of each kind of token.
	 * 
	 * @param numRoads the number of roads the player should have left.
	 * Must be a non-negative integer.
	 * @param numSettlements the number of settlements the player should
	 * have left. Must be a non-negative integer.
	 * @param numCities the number of cities the player should have
	 * left. Must be a non-negative integer.
	 * @throws NegativeGameComponentsException if any of the parameters
	 * are negative.
	 */
	public TokenManager(int numRoads, int numSettlements, int numCities) 
			throws NegativeGameComponentsException {

	}

	/**
	 * Constructor. Initializes the TokenManager for the beginning of a
	 * game.
	 */
	public TokenManager() throws NegativeGameComponentsException {
		this(15, 5, 4);
	}

	public TokenType getRoads() {
		return roads;
	}

	public TokenType getSettlements() {
		return settlements;
	}

	public TokenType getCities() {
		return cities;
	}

}