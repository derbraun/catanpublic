package shared.inputObjects;

/**
 * Holds the input parameters needed for RollDice()
 */
public class RollDiceInput extends InputObject {

	/**
	 * The ID of the player who rolled the dice
	 */
	int playerID;
	
	/**
	 * The number that was rolled by the dice
	 */
	int numberRolled;

	/**
	 * Creates an instance of the RollDice input parameters object
	 * @param playerID The ID of the player who rolled the dice
	 * @param numberRolled The number that was rolled by the dice
	 * @pre playerID is not null and is an existing player, and numberRolled is not null and a valid number between 2-12
	 * @post A RollDiceInput object is created
	 */
	public RollDiceInput(int playerID, 
						 int numberRolled) {
		this.playerID = playerID;
		this.numberRolled = numberRolled;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public int getNumberRolled() {
		return numberRolled;
	}

	public void setNumberRolled(int numberRolled) {
		this.numberRolled = numberRolled;
	}
}
