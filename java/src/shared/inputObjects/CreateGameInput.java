package shared.inputObjects;

/**
 * Holds the input parameters needed for CreateGame()
 */
public class CreateGameInput extends InputObject {

	/**
	 * The new game's name
	 */
	String name;
	
	/**
	 * Indicates whether or not to randomize the tiles
	 */
	boolean randomTiles;
	
	/**
	 * Indicates whether or not to randomize the number tokens
	 */
	boolean randomNumbers;
	
	/**
	 * Indicates whether or not to randomize the ports
	 */
	boolean randomPorts;
	
	/**
	 * Creates an instance of the CreateGame input parameters object
	 * @param name the new game's name
	 * @param randomTiles Whether or not to randomize the tiles
	 * @param randomNumbers Whether or not to randomize the number tokens
	 * @param randomPorts Whether or not to randomize the ports
	 * @pre name is not null, and randomTiles, randomNumbers and randomPorts are valid boolean values
	 * @post A CreateGameInput object is created
	 */
	public CreateGameInput(String name,
						   boolean randomTiles,
						   boolean randomNumbers,
						   boolean randomPorts) {

		this.name = name;
		this.randomTiles = randomTiles;
		this.randomNumbers = randomNumbers;
		this.randomPorts = randomPorts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRandomTiles() {
		return randomTiles;
	}

	public void setRandomTiles(boolean randomTiles) {
		this.randomTiles = randomTiles;
	}

	public boolean isRandomNumbers() {
		return randomNumbers;
	}

	public void setRandomNumbers(boolean randomNumbers) {
		this.randomNumbers = randomNumbers;
	}

	public boolean isRandomPorts() {
		return randomPorts;
	}

	public void setRandomPorts(boolean randomPorts) {
		this.randomPorts = randomPorts;
	}
}
