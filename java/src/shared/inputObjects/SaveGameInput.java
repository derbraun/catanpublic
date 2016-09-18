package shared.inputObjects;

/**
 * Holds the input parameters needed for SaveGame()
 */
public class SaveGameInput extends InputObject {

	/**
	 * The ID of the game to save
	 */
	int gameID;
	
	/**
	 * The name of the file to be saved as
	 */
	String fileName;

	/**
	 * Creates an instance of the SaveGame input parameter object
	 * @param gameID the ID of the game to save
	 * @param fileName the name of the file to be saved as
	 * @pre gameID is an existing game and filename is not null or empty
	 * @post A SaveGameInput object is created
	 */
	public SaveGameInput(int gameID,
						 String fileName) {
		this.gameID = gameID;
		this.fileName = fileName;
	}
}
