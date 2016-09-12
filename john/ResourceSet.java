package john;

import john.ResourceManager;
import john.Player;

public class ResourceSet {

	private ResourceManager bricks;
	private ResourceManager wood;
	private ResourceManager sheep;
	private ResourceManager grain;
	private ResourceManager ore;
	private Player player;

	public Market() {

	}

	public ResourceManager getBricks() {
		return bricks;
	}

	public ResourceManager getWood() {
		return wood;
	}

	public ResourceManager getSheep() {
		return sheep;
	}

	public ResourceManager getGrain() {
		return grain;
	}

	public ResourceManager getOre() {
		return ore;
	}

	public Player getPlayer() {
		return player;
	}

	public boolean canBuyRoad() {

	}

	public boolean canBuySettlement() {

	}

	public boolean canBuyCity() {

	}

	public boolean canBuyDevelopmentCard() {

	}

}