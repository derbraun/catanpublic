package shared.models;

/** holds information about a player's settlement, city, and road tokens
 */
public class TokenManager {

	private int roads;
	private int settlements;
	private int cities;

	/** Constructor. Starts the player out with 15 roads, 5
	 * settlements, and 4 cities that can be played.
	 */
	public TokenSet() {
		roads = 15;
		settlements = 5;
		cities = 4;
	}

	/**
	 * @return the number of roads the user has left
	 */
	public int getRoadsLeft() {
		return roads;
	}

	/** remove one road from the player's unused roads
	 */
	public void removeRoad() {
		roads--;
	}

	/**
	 * @return true if the player still has unused roads, otherwise
	 * false
	 */
	public boolean hasRoadsLeft() {
		return roads != 0;
	}

	/**
	 * @return the number of settlements the user has left
	 */
	public int getSettlementsLeft() {
		return settlements;
	}

	/** remove one settlement from the player's unused settlements
	 */
	public void removeSettlement() {
		settlements--;
	}

	/**
	 * @return true if the player still has unused settlements,
	 * otherwise false
	 */
	public boolean hasSettlementsLeft() {
		return settlements != 0;
	}

	/**
	 * @return the number of cities the user has left
	 */
	public int getCitiesLeft() {
		return cities;
	}

	/** remove one city from the player's unused cities
	 */
	public void removeCity() {
		cities--;
	}

	/**
	 * @return true if the player still has unused cities, otherwise
	 * false
	 */
	public boolean hasCitiesLeft() {
		return roads != 0;
	}

}