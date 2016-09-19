package shared.models;

import shared.models.exceptions.NegativeGameComponentsException;

/**
 * Class for managing a player's resources.
 */
public class ResourceManager {

	private ResourceType bricks;
	private ResourceType wood;
	private ResourceType grain;
	private ResourceType sheep;
	private ResourceType ore;

	/**
	 * Constructor. Initializes ResourceManager with the given number
	 * of each resource.
	 * 
	 * @param numBricks the number of bricks the player should have.
	 * Must be non-negative.
	 * @param numWood the number of wood cards the player should have.
	 * Must be non-negative.
	 * @param numGrain the number of grain cards the player should have.
	 * Must be non-negative.
	 * @param numSheep the number of sheep cards the player should have.
	 * Must be non-negative.
	 * @param numOre the number of ore cards the player should have.
	 * Must be non-negative.
	 * @throws NegativeGameComponentsException if any of the parameters
	 * are negative.
	 */
	public ResourceManager(int numBricks, int numWood, int numGrain,
			int numSheep, int numOre) throws NegativeGameComponentsException {
	}

	/**
	 * Constructor. Initializes ResourceManager for start of game.
	 */
	public ResourceManager() throws NegativeGameComponentsException {
		this(0, 0, 0, 0, 0);
	}

	public ResourceType getBricks() {
		return bricks;
	}

	public ResourceType getWood() {
		return wood;
	}

	public ResourceType getGrain() {
		return grain;
	}

	public ResourceType getSheep() {
		return sheep;
	}

	public ResourceType getOre() {
		return ore;
	}

	/**
	 * Checks whether the player can afford to build a road.
	 * 
	 * @return true if the player can afford a road, false otherwise.
	 */
	public boolean canAffordRoad() {
		return bricks.numLeft() >= 1 && wood.numLeft() >= 1;
	}

	/**
	 * Checks whether the player can afford to build a settlement.
	 * 
	 * @return true if the player can afford a settlement, false
	 * otherwise.
	 */
	public boolean canAffordSettlement() {
		return bricks.numLeft() >= 1 && wood.numLeft() >= 1
			&& grain.numLeft() >= 1 && sheep.numLeft() >= 1;
	}

	/**
	 * Checks whether the player can afford to build a city.
	 * 
	 * @return true if the player can afford a city, false otherwise.
	 */
	public boolean canAffordCity() {
		return grain.numLeft() >= 2 && ore.numLeft() >= 3;
	}

	/**
	 * Checks whether the player can afford to buy a development card.
	 * 
	 * @return true if the player can afford a development card, false
	 * otherwise.
	 */
	public boolean canAffordDevelopmentCard() {
		return sheep.numLeft() >= 1 && grain.numLeft() >= 1
			&& ore.numLeft() >= 1;
	}

	/**
	 * Gets the total number of resource cards the player has. This
	 * is useful when a 7 is rolled and players with more than 7
	 * resource cards must discard half of them.
	 * 
	 * @return the total number of resources the player has.
	 */
	public int totalResources() {
		return bricks.numLeft() + wood.numLeft() + sheep.numLeft()
			+ grain.numLeft() + ore.numLeft();
	}

}