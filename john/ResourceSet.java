package john;

import john.ResourceManager;
import john.Player;

/** a class representing some set of resources
 */
public class ResourceSet {

	private ResourceManager bricks;
	private ResourceManager wood;
	private ResourceManager sheep;
	private ResourceManager grain;
	private ResourceManager ore;

	public ResourceSet() {

	}

	/**
	 * @return an object containing information on the number of
	 * bricks
	 */
	public ResourceManager getBricks() {
		return bricks;
	}

	/**
	 * @return an object containing information on the number of
	 * wood
	 */
	public ResourceManager getWood() {
		return wood;
	}

	/**
	 * @return an object containing information on the number of
	 * sheep
	 */
	public ResourceManager getSheep() {
		return sheep;
	}

	/**
	 * @return an object containing information on the number of
	 * grains
	 */
	public ResourceManager getGrain() {
		return grain;
	}

	/**
	 * @return an object containing information on the number of
	 * ores
	 */
	public ResourceManager getOre() {
		return ore;
	}

	/**
	 * @return true if this object contains the resources to buy a
	 * road, otherwise false
	 */
	public boolean canBuyRoad() {

	}

	/**
	 * @return true if this object contains the resources to buy a
	 * settlement, otherwise false
	 */
	public boolean canBuySettlement() {

	}

	/**
	 * @return true if this object contains the resources to buy a
	 * city, otherwise false
	 */
	public boolean canBuyCity() {

	}

	/**
	 * @return true if this object contains the resources to buy a
	 * development card, otherwise false
	 */
	public boolean canBuyDevelopmentCard() {

	}

	/** adds the resources of another ResourceSet to this one
	 * @param addable the ResourceSet from which to add resources
	 */
	public void add(ResourceSet addable) {

	}

}