package shared.outputObjects;

/**
 * A generalized output parameter object class
 * @author Dell
 *
 */
public abstract class OutputObject {

	/**
	 * Creates an instance of the OutputObject class
	 */
	public OutputObject() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Indicates whether the operation failed or not
	 */
	public abstract boolean Failed();

}
