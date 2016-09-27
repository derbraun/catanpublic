package shared.models.exceptions;

/**
 * Exception thrown when a road is attempted to be placed on an edge
 * where it cannot be placed
 * @author Cory
 *
 */
public class InvalidRoadPlacementException extends Exception {
	
	public InvalidRoadPlacementException() {
		super();
	}
	
	public InvalidRoadPlacementException(String message) {
		super(message);
	}
	
	public InvalidRoadPlacementException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InvalidRoadPlacementException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public InvalidRoadPlacementException(Throwable cause) {
		super(cause);
	}
	
}