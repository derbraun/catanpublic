package john;

import java.util.List;

import john.DevelopmentCardSet;
import john.Player;
import john.Log;

/** represents a single game of Settlers of Catan
 */
public class Game {

	private DevelopmentCardSet developmentCards;
	private List<Player> players;
	private Log chat;
	private Log history;
	private Player currentPlayer;

	public Game() {
		
	}

	/**
	 * @return an object for managing all of the development cards still
	 * in the development card pile
	 */
	public DevelopmentCardSet getDevelopmentCards() {
		return developmentCards;
	}

	/**
	 * @return a list of players participating in the game
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * @return an object containing the data for the chat box
	 */
	public Log getChat() {
		return chat;
	}

	/**
	 * @return an object containing data for the history box
	 */
	public Log getHistory() {
		return history;
	}

	/**
	 * @return the player whose turn it is
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

}