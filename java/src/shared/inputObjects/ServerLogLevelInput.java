package shared.inputObjects;

/**
 * Holds the input parameters needed for SetServerLogLevel()
 */
public class ServerLogLevelInput extends InputObject {

	/**
	 * The server logging level to be set
	 */
	String loggingLevel;

	/**
	 * Creates an instance of ServerLogLevel input parameters
	 * @param loggingLevel The server logging level to be set
	 * @pre loggingLevel is a valid logging level (SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST)
	 * @post A ServerLogLevelInput object is created
	 */
	public ServerLogLevelInput(String loggingLevel) {
		this.loggingLevel = loggingLevel;
	}

	public String getLoggingLevel() {
		return loggingLevel;
	}

	public void setLoggingLevel(String loggingLevel) {
		this.loggingLevel = loggingLevel;
	}
}
