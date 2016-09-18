package shared.models.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import shared.definitions.PlayerIndex;
import shared.definitions.ResourceType;

/**
 * The result of the Resource Production Phase of a Turn in
 * Settlers of Catan. Reports how much of what materials goes to
 * which player.
 * @author Cory
 *
 */
public class ResProdResult {
	
	/**
	 * Holds total number of resources per resource type
	 */
	private Map<ResourceType,Integer> numPerResource;
	
	/**
	 * For each player, there is an list of Resource Types 
	 * (The same type may reoccur denoting multiple resources)
	 */
	private Map<PlayerIndex,List<ResourceType>> resourcesByPlayer;
	
	
	public ResProdResult() {
		this.numPerResource = new HashMap<ResourceType,Integer>();
		this.resourcesByPlayer = new HashMap<PlayerIndex,List<ResourceType>>();
	}
	
	/**
	 * Adds a resource production result of one or more resources to be given to a certain Player
	 * @param pIndex the Player index
	 * @param type The Resource type
	 * @param numResource The number of resources to distribute
	 * 
	 * @pre PlayerIndex != null
	 * @pre ResourceType != null
	 * @pre numResources > 0
	 * 
	 * @post numPerResource.containsKey(type) = true
	 * @post old numPerResource.get(type) = new numPerResource.get(type) + numResources
	 * @post resourcesByPlayer.containsKey(pIndex) = true
	 * @post getNumResOfTypeForPlayer(pIndex,type) = numResources
	 * 
	 */
	public void addResult(PlayerIndex pIndex, ResourceType type, int numResource){
		
	}

	/**
	 * Gets the number of a specific resource that is to be distributed this turn to all players
	 * @param type The type of Resource
	 * @return The number of resources to distribute
	 */
	public int getNumResOfType(ResourceType type){
		return 0;
	}
	
	/**
	 * Gets the number of a specific resource that is to be distributed this turn to one player
	 * @param pIndex The index of the Player
	 * @param type The type of Resource
	 * @return the number of resources to distribute to the player
	 */
	public int getNumResOfTypeForPlayer(PlayerIndex pIndex,ResourceType type){
		return 0;
	}
}
