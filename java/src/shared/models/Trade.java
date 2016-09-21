/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.models;

/**
 * Contains information about a transaction between two players
 * or between a player and the bank.
 * 
 * @author John Larson
 */
public class Trade {
	
	private final ResourceManager give;
	private final ResourceManager receive;
	
	public Trade() {
		give = new ResourceManager();
		receive = new ResourceManager();
	}
	
	public ResourceManager getGivenResources() {
		return give;
	}
	
	public ResourceManager getReceivedResources() {
		return receive;
	}
	
}
