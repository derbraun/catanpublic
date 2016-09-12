package john;

import john.DevelopmentCardManager;
import john.Player;
import john.Log;

public class Game {

	private DevelopmentCardManager developmentCards;
	private List<Player> players;
	private Log chat;
	private Log history;
	private Player currentPlayer;

	public Game() {
		
	}

	public DevelopmentCardManager getDevelopmentCards() {
		return developmentCards;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public Log getChat() {
		return chat;
	}

	public Log getHistory() {
		return history;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

}