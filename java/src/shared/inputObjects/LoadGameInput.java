package shared.inputObjects;

/**
 * Holds the input parameters needed for LoadGame()
 */
public class LoadGameInput extends InputObject {

	/**
	 * The fileName of the game to load
	 */
	String fileName;
	
	/**
	 * Creates an instance of the LoadGame input parameters object
	 * @param fileName the name of the file to load
	 * @pre fileName is not null or empty
	 * @post A LoadGameInput object is created
	 */
	public LoadGameInput(String fileName)
	{
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
