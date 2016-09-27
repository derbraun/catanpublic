package shared.models.map;

import java.util.ArrayList;
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
		if (pIndex == null || type == null || numResource < 1){
			throw new IllegalArgumentException();
		}
		numPerResource.put(type, numPerResource.getOrDefault(type, 0) + numResource);
		if (!resourcesByPlayer.containsKey(pIndex)){
			resourcesByPlayer.put(pIndex, new ArrayList<ResourceType>());
		}
		for (int i = 0; i < numResource; i++){
			resourcesByPlayer.get(pIndex).add(type);
		}
	}

	/**
	 * Gets the number of a specific resource that is to be distributed this turn to all players
	 * @param type The type of Resource
	 * @return The number of resources to distribute
	 */
	public int getNumResOfType(ResourceType type){
		if (type == null){
			throw new IllegalArgumentException();
		}
		return numPerResource.get(type);
	}
	
	/**
	 * Gets the number of a specific resource that is to be distributed this turn to one player
	 * @param pIndex The index of the Player
	 * @param type The type of Resource
	 * @return the number of resources to distribute to the player
	 */
	public int getNumResOfTypeForPlayer(PlayerIndex pIndex,ResourceType type){
		if (pIndex == null || type == null){
			throw new IllegalArgumentException();
		}
		int numResources = 0;
		List<ResourceType> playerResources = resourcesByPlayer.get(pIndex);
		for (ResourceType elem : playerResources){
			if (elem.equals(type)){
				numResources++;
			}
		}
		return numResources;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numPerResource == null) ? 0 : numPerResource.hashCode());
		result = prime * result + ((resourcesByPlayer == null) ? 0 : resourcesByPlayer.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResProdResult other = (ResProdResult) obj;
		if (numPerResource == null) {
			if (other.numPerResource != null)
				return false;
		} else if (!numPerResource.equals(other.numPerResource))
			return false;
		if (resourcesByPlayer == null) {
			if (other.resourcesByPlayer != null)
				return false;
		} else if (!resourcesByPlayer.equals(other.resourcesByPlayer))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResProdResult [numPerResource=" + numPerResource + ", resourcesByPlayer=" + resourcesByPlayer + "]";
	}
	
	
}
