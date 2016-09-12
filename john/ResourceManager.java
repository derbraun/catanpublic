package john;



public class ResourceManager {

	private int amount;
	private ResourceManager resourceManager;

	public ResourceManager() {
		
	}

	public int getAmount() {
		return amount;
	}

	public void add(int addAmount) {
		amount += addAmount;
	}

	public void remove(int removeAmount) {
		amount -= removeAmount;
	}

	public ResourceManager getResourceManager() {
		return market;
	}

}