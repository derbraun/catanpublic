package john;



public class ResourceManager {

	private int amount;
	private Market market;

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

	public Market getMarket() {
		return market;
	}

}