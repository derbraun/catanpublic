package shared.models.exceptions;

/**
 * Exception that is thrown when an edge that cannot be adjacent
 * to the vertex/edge is attempted to be added as an adjacent 
 * edge to said vertex/edge
 * @author Cory
 *
 */
public class EdgeNotAdjacentException extends Exception {
	
	public EdgeNotAdjacentException() {
		super();
	}
	
	public EdgeNotAdjacentException(String message) {
		super(message);
	}
	
	public EdgeNotAdjacentException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EdgeNotAdjacentException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public EdgeNotAdjacentException(Throwable cause) {
		super(cause);
	}
	
}