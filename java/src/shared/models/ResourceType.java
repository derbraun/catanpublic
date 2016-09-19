package shared.models;

import shared.models.exceptions.NegativeGameComponentsException;

/**
 * Contains information about how much of a specific resource a player
 * has.
 */
public class ResourceType {

	private int remaining;

	/**
	 * Constructor. Initializes the given ResourceType with the given
	 * amount of remaining resources of this type.
	 * 
	 * @param amount the amount of the resource that the player has
	 * left. Must be non-negative.
	 * @throws NegativeGameComponentsException if amount is negative.
	 */
	public ResourceType(int amount)throws NegativeGameComponentsException {
		remaining = amount;
	}

	/**
	 * Gets the number of the resource that the player has.
	 * 
	 * @return the number of this resource that the player has left.
	 */
	public int numLeft() {
		return remaining;
	}

	/**
	 * Simulates drawing resource cards by adding the given number of
	 * the resource to this ResourceType's remaining amount.
	 * 
	 * @param amount the number of the resource to draw. Must be
	 * non-negative.
	 * @post The player has `amount` more of the resource than before.
	 * @throws NegativeGameComponentsException if amount is negative.
	 */
	 public void draw(int amount) throws NegativeGameComponentsException {
	 	remaining += amount;
	 }

	 /**
	  * Simulates discarding resource cards by subtracting the given
	  * number of the resource from this ResourceType's remaining
	  * amount.
	  * 
	  * @param amount the number of the resource to discard. Must be
	  * non-negative.
	  * @pre The player has at least `amount` left of this resource.
	  * @post The player has `amount` less of the resource than before.
	  * @throws NegativeGameComponentsException if amount is negative or
	  * player has less than amount of this resource.
	  */
	 public void discard(int amount) throws NegativeGameComponentsException {
	 	remaining -= amount;
	 }

}