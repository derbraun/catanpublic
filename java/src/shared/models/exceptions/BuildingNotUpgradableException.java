package shared.models.exceptions;

/**
 * An exception that is thrown when a building was called 
 * to updgrade to a settlement when it could not
 * @author Cory
 *
 */
public class BuildingNotUpgradableException extends Exception {
	
	public BuildingNotUpgradableException() {
		super();
	}
	
	public BuildingNotUpgradableException(String message) {
		super(message);
	}
	
	public BuildingNotUpgradableException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BuildingNotUpgradableException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public BuildingNotUpgradableException(Throwable cause) {
		super(cause);
	}
	
}