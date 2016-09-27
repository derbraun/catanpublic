package shared.models.exceptions;

/**
 * Exception that is thrown when a vertex that cannot be adjacent
 * to a vertex is attempted to be added as an adjacent 
 * edge to said vertex
 * @author Cory
 *
 */
public class VertexNotAdjacentException extends Exception {
	
	public VertexNotAdjacentException() {
		super();
	}
	
	public VertexNotAdjacentException(String message) {
		super(message);
	}
	
	public VertexNotAdjacentException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public VertexNotAdjacentException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public VertexNotAdjacentException(Throwable cause) {
		super(cause);
	}
	
}