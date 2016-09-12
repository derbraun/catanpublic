package john;

import String;

import john.Game;
import john.TokenManager;
import john.DevelopmentCardManager;
import john.Market;
import john.User;

public class Player {

	private int points;
	private int numSoldiers;
	private String color;
	private Game game;
	private TokenManager tokens;
	private DevelopmentCardManager developmentCards;
	private Market market;
	private User user;

	public Player(User user, String color) {

	}

	public void addPoint() {
		points++;
	}

	public void addPoints(int numPoints) {
		points += numPoints;
	}

	public void removePoint() {
		points--;
	}

	public void removePoints(int numPoints) {
		points -= numPoints;
	}

	public int getNumPoints() {
		return points;
	}

	public void addSoldier() {
		numSoldiers++;
	}

	public int getNumSoldiers() {
		return numSoldiers;
	}

	public String getColor() {
		return color;
	}

	public void setGame(Game aGame) {
		game = aGame;
	}

	public Game getGame() {
		return game;
	}

	public User getUser() {
		return user;
	}

	public String getName() {

	}

	public TokenManager getTokens() {
		return tokens;
	}

	public DevelopmentCardManager getDevelopmentCards() {
		return developmentCards;
	}

	public Market getMarket() {
		return market;
	}

	public boolean hasLargestArmy() {

	}

	public boolean hasLongestRoad() {

	}

	public boolean canBuildRoad() {

	}

	public boolean canBuildSettlement() {

	}

	public boolean canBuildCity() {

	}

	public boolean canBuyDevelopmentCard() {

	}

	public boolean isOnTurn() {

	}

}