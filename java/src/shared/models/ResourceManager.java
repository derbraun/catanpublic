package shared.models;

/** class for managing a player's resources
 */
class ResourceManager {

	private int bricks;
	private int wood;
	private int grain;
	private int sheep;
	private int ore;

	/** Constructor. Starts the player out with zero resources
	 */
	public ResourceManager() {
		bricks = 0;
		wood = 0;
		grain = 0;
		sheep = 0;
		ore = 0;
	}

	/**
	 * @return the number of bricks the player has
	 */
	public int numBricks() {
		return bricks;
	}

	/** have the player draw the specified number of bricks
	 * @param amount the amount of bricks to draw
	 */
	public void drawBricks(int amount) {
		bricks += amount;
	}

	/** have the player discard the specified number of bricks
	 * @param amount the number of bricks to discard
	 */
	public void discardBricks(int amount) {
		bricks -= amount;
	}

	/**
	 * @return the amount of wood the player has
	 */
	public int numWood() {
		return wood;
	}

	/** have the player draw the specified number of wood cards
	 * @param amount the amount of wood cards to draw
	 */
	public void drawWood(int amount) {
		wood += amount;
	}

	/** have the player discard the specified number of wood cards
	 * @param amount the amount of wood cards to discard
	 */
	public void discardWood(int amount) {
		wood -= amount;
	}

	/**
	 * @return the amount of grain the player has
	 */
	public int numGrain() {
		return grain;
	}

	/** have the player draw the specified number of grain cards
	 * @param amount the amount of grain cards to draw
	 */
	public void drawGrain(int amount) {
		grain += amount;
	}

	/** have the player discard the specified number of grain cards
	 * @param amount the amount of grain cards to discard
	 */
	public void discardGrain(int amount) {
		grain -= amount
	}

	/**
	 * @return the amount of sheep the player has
	 */
	public int numSheep() {
		return sheep;
	}

	/** have the player draw the specified number of sheep cards
	 * @param amount the amount of sheep cards to draw
	 */
	public void drawSheep(int amount) {
		sheep += amount;
	}

	/** have the player discard the specified number of sheep cards
	 * @param amount the amount of sheep cards to discard
	 */
	public void discardSheep(int amount) {
		sheep -= amount;
	}

	/**
	 * @return the amount of ore the player has
	 */
	public int numOre() {
		return ore;
	}

	/** have the player draw the specified number of ore cards
	 * @param amount the amount of ore cards to draw
	 */
	public void drawOre(int amount) {
		ore += amount;
	}

	/** have the player discard the specified number of ore cards
	 * @param amount the amount of ore cards to discard
	 */
	public void discardOre(int amount) {
		ore -= amount;
	}

	/**
	 * @return true if the player can afford a road, false otherwise
	 */
	public boolean canAffordRoad() {
		return brick >= 1 && wood >= 1;
	}

	/**
	 * @return true if the player can afford a settlement, false otherwise
	 */
	public boolean canAffordSettlement() {
		return brick >= 1 && wood >= 1 && grain >= 1 && sheep >= 1;
	}

	/**
	 * @return true if the player can afford a city, false otherwise
	 */
	public boolean canAffordCity() {
		return grain >= 2 && ore >= 3;
	}

	/**
	 * @return true if the player can afford a development card, false
	 * otherwise
	 */
	public boolean canAffordDevelopmentCard() {
		return sheep >= 1 && grain >= 1 && ore >= 1;
	}

	/** returns the total number of resource cards the player has. This
	 * is useful when a 7 is rolled and players with more than 7
	 * resource cards must discard half of them
	 */
	public int totalResources() {
		return bricks + wood + sheep + grain + ore;
	}

}