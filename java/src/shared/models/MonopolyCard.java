/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.models;

import org.json.JSONObject;
import shared.definitions.ResourceType;

/**
 *
 * @author daniel
 */
public abstract class MonopolyCard extends ProgressCard{
    private ResourceType resource;
    
    /**
     * Default Constructor
     */
    public MonopolyCard(){}
    
    /**
     * Constructor that takes a JSON object and creates a new Monopoly Card out of it
     * @param card 
     */
    public MonopolyCard(JSONObject card){
        
    }
    /**
     * overrided version of playCard
     * Plays the card and activates its effect on the map 
     * (player gains all resources of chosen type)
     *
     * @pre card is in a player's hand and is a valid card
     * @post card's effect, based off of it's subclass, is invoked on the game
     * @param player
     */
    @Override
    public void playCard(Player player) {
        
        collectResources(player);
       
    }
    
    /**
     * overrided version of canPlayCard
     * Checks to make sure the card is a valid card
     * @pre player hasn't played a development card yet
     * @return boolean on whether the card can be played
     */
    @Override
    public boolean canPlayCard() {
        return true;
    }
    /**
     * Calls the Singleton to gain all other players' resources of specific type
     * @pre Resource Type is not null
     * @post All other players lose selected resource and the total resources lost are given to the player 
     * @param player 
     */
    private void collectResources(Player player) throws NoResourceDefinedException{
        
    }

    public ResourceType getResource() {
        return resource;
    }

    
    /**
     * Specifies which resource to monopolize
     * @pre resource is a valid ResourceType
     * @param resource 
     */
    public void nameResource(ResourceType resource) {
        this.resource = resource;
    }
    
}

class NoResourceDefinedException extends Exception
{
      //Parameterless Constructor
      public NoResourceDefinedException() {}

      //Constructor that accepts a message
      public NoResourceDefinedException(String message)
      {
         super(message);
      }
 }