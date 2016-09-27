package shared.models.exceptions;

/**
 * Exception thrown when an attempt to place a building on a vertex
 * is not possible
 * @author Cory
 *
 */
public class InvalidBuildingPlacementException extends Exception {
	
	public InvalidBuildingPlacementException() {
		super();
	}
	
	public InvalidBuildingPlacementException(String message) {
		super(message);
	}
	
	public InvalidBuildingPlacementException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InvalidBuildingPlacementException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public InvalidBuildingPlacementException(Throwable cause) {
		super(cause);
	}
	
}