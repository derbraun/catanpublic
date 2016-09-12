package john;

/** an object for viewing and changing information about the amount of
 * a certain resource
 */
public class ResourceManager {

	private int amount;

	public ResourceManager() {
		
	}

	/**
	 * @return the amount of the resource left
	 */
	public int getAmount() {
		return amount;
	}

	/** increases the resource by a certain amount
	 * @param addAmount the amount to increase the resource by
	 */
	public void add(int addAmount) {
		amount += addAmount;
	}

	/** decreases the resource by a certain amount
	 * @param addAmount the amount to decrease the resource by
	 */
	public void remove(int removeAmount) {
		amount -= removeAmount;
	}

}