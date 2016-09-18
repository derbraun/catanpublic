package client;

import java.util.List;
import shared.definitions.ResourceType;

/*
 * The ResourceCards Class
 */
public class ResourceCards {
	
	/**
	 * Checks if the specified resource is valid
	 * @param resource The resource to validate
	 * @return A boolean indicating whether the resource is valid or not
	 * @pre resource is not null or invalid
	 * @post It is reported back that the resource is valid or not
	 */
	private boolean IsValidResource(ResourceType resource)
	{
		boolean isValid = false;
		
		if (resource == ResourceType.BRICK
			|| resource == ResourceType.ORE
			|| resource == ResourceType.SHEEP
			|| resource == ResourceType.WHEAT
			|| resource == ResourceType.WOOD)
		{
			isValid = true;
		}
		
		return isValid;
	}

	/**
	 * Give a specified resource to a player from the stack
	 * @param playerID The ID of the player who will receive the resource
	 * @param resource The type of resource to be given
	 * @return A boolean indicating success or not
	 * @pre playerID is not 0 or invalid and resource is not null or invalid
	 * @post The player model will reflect the new number of resources
	 */
	public boolean GivePlayerResource(int playerID,
								 	  ResourceType resource) 
	{
		// Check if the player ID is valid
		if (playerID < 0) // || !PlayerExists(playerID)
		{
			return false;
		}
		
		// Check if the resource is valid
		if (resource == null || !IsValidResource(resource))
		{
			return false;
		}
		
		// Give the player the specified resource
		
		return false;
	}
	
	/**
	 * Trades Resources between two players
	 * @param traderID The ID of the player who initiated the trade
	 * @param traderResources A list of resources the first player is willing to trade
	 * @param tradeeID The ID of the player who wants to be traded with
	 * @param tradeeResources A list of resources the trader wants from the tradee
	 * @return A boolean indicating a successful trade
	 * @pre traderID is not 0 or invalid, traderResources is not null or invalid, tradeeID is not 0 or invalid and tradeeResources is not null or invalid
	 * @post If the trade was successful, the player models will reflect the new resources. If unsuccessful, nothing happens
	 */
	public boolean Trade(int traderID,
						 List<ResourceType> traderResources,
						 int tradeeID,
						 List<ResourceType> tradeeResources)
	{
		if (traderID > 0) // || !PlayerExists(traderID)
		{
			return false;			
		}
		
		if (traderResources.isEmpty()) 
		{
			return false;
		}
		else
		{
			for (int i = 0; i < traderResources.size(); i++)
			{
				if (!IsValidResource(traderResources.get(i)))
				{
					return false;
				}
			}
		}
		
		if (tradeeID > 0) // || !PlayerExists(tradeeID)
		{
			return false;			
		}
		
		if (tradeeResources.isEmpty()) 
		{
			return false;
		}
		else
		{
			for (int i = 0; i < tradeeResources.size(); i++)
			{
				if (!IsValidResource(tradeeResources.get(i)))
				{
					return false;
				}
			}
		}
		
		// Perform trade
		
		return false;
	}
	
	/**
	 * Checks if the specified player has the resource they want to trade / discard
	 * @param playerID The ID of the player to check
	 * @param resource The resource to check that the player has
	 * @return A boolean indicating whether or not the player has the resource
	 * @pre playerID is not 0 or invalid, resource is not null or invalid
	 * @post It is reported back that the player has the resource available to trade / discard or not
	 */
	public boolean PlayerHasResource(int playerID,
									 ResourceType resource)
	{
		if (playerID > 0) // || !PlayerExists(playerID)
		{
			return false;			
		}
		
		if (!IsValidResource(resource))
		{
			return false;
		}
		
		// Check if the player has the resource, if not, the player can't make the trade or discard
		
		return false;
	}
	
	/**
	 * Discards the specified resource from the player and returns it to the stack
	 * @param playerID The ID of the player the resource will be discarded from
	 * @param resource The resource to be discarded
	 * @return A boolean indicating a successful discard
	 * @pre player is not 0 or invalid, resource is not null or invalid
	 * @post If the discard is successful, the resource will be made available in the stack and the player will no longer have that resource
	 */
	public boolean DiscardResource(int playerID,
								   ResourceType resource)
	{
		if (playerID < 0) // || !PlayerExists(playerID)
		{
			return false;
		}
		
		if (resource == null || !IsValidResource(resource))
		{
			return false;
		}
		
		// Discard the resource card
		
		return false;
	}
	
	/**
	 * Exchanges the players resources for a Development card
	 * @param playerID The ID of the player who wants to buy a Development card
	 * @return A boolean indicating a successful exchange
	 * @pre playerID is not 0 or invalid
	 * @post If the exchange was successful, the player models will reflect the removed resources and the new Development card. If unsuccessful, nothing happens
	 */
	public boolean BuyDevelopmentCard(int playerID)
	{
		if (playerID < 0) // || !PlayerExists(playerID)
		{
			return false;
		}
		
		return false;
	}
	
	/**
	 * Checks if the player has the resources to exchange for a Development card
	 * @param playerID The ID of the player who wants to buy a Development card
	 * @return A boolean indicating that the player has enough resources to exchange
	 * @pre playerID is not 0 or invalid
	 * @post It is reported back that the player has enough resources or not to make the purchase / exchange
	 */
	public boolean CanPlayerBuyDevelopmentCard(int playerID)
	{
		if (playerID < 0) // || !PlayerExists(playerID)
		{
			return false;
		}
		
		return false;
	}
	
	/**
	 * Gets the number of cards for a specific resource that a player has
	 * @param playerID The ID of the player that is being checked
	 * @param resource The resource to be counted
	 * @return An int representing the count of a specific resource that a player has
	 * @throws "Player does not exist" Exception or "Resource is not valid" Exception
	 * @pre playerID is not 0 or invalid, resource is not null or invalid
	 * @post A value will be returned that represents the amount of a resource the player has
	 */
	public int GetNumberOfResourceForPlayer(int playerID,
										    ResourceType resource) throws Exception
	{
		int resourceCount = 0;
		
		if (playerID < 0) // || !PlayerExists(playerID)
		{
			throw new Exception("Player doesn't exist");
		}
		
		if (resource != null || !IsValidResource(resource))
		{
			throw new Exception("Resource is not valid");
		}
		
		return resourceCount;
	}
	
	/**
	 * Gets the total number of resources that a player has
	 * @param playerID The ID of the player that is being checked
	 * @return An int representing the total number of resources that a player has
	 * @throws "Player does not exist" Exception
	 * @pre playerID is not 0 or invalid
	 * @post A value will be returned that represents the total number of resources the player has
	 */
	public int GetTotalResourcesForPlayer(int playerID) throws Exception
	{
		int resourceCount = 0;
		
		if (playerID < 0) // || !PlayerExists(playerID)
		{
			throw new Exception("Player doesn't exist");
		}
		
		return resourceCount;
	}
	
	/**
	 * Discards half of the players resources if they have more than a total of 7 and the dice rolled 7
	 * @param playerID The ID of the player that is being checked
	 * @return A boolean that indicates whether the resources were successfully discarded from the player
	 * @throws "Player does not exist" Exception
	 * @pre playerID is not 0 or invalid
	 * @post If the operation is successful, the player model will reflect the discarded resource cards from their deck
	 */
	public boolean DiscardHalfOfResources(int playerID) throws Exception
	{
		if (playerID < 0) // || !PlayerExists(playerID)
		{
			throw new Exception("Player does not exist");
		}
		
		int playerResourceCount = GetTotalResourcesForPlayer(playerID);
		
		if (playerResourceCount >= 7)
		{
			int resourcesToRemove = 0;
			
			if (playerResourceCount % 2 == 0) // Even
			{
				resourcesToRemove = playerResourceCount / 2;
			}
			else // Odd
			{
				resourcesToRemove = (playerResourceCount - 1) / 2;
			}
			
			// Remove the resources
			return true;
		}
		
		return false;
	}
}
