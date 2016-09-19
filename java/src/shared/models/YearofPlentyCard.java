/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.models;

import org.json.JSONObject;

/**
 *
 * @author daniel
 */
public class YearofPlentyCard extends ProgressCard{
    /**
     * Default Constructor
     */
    public YearofPlentyCard(){}
    
    /**
     * Constructor that takes a JSON object and creates a new Year of Plenty Card out of it
     * @param card 
     */
    public YearofPlentyCard(JSONObject card){
        
    }
    /**
     * overrided version of playCard
     * Plays the card and activates its effect on the map 
     * (player gains 2 resources of any type)
     *
     * @pre card is in a player's hand and is a valid card
     * @post card's effect, based off of it's subclass, is invoked on the game
     * @param player 
     */
    @Override
    public void playCard(Player player) {
        
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
     * Calls the Singleton to add 2 resources to player
     * 
     * @param player 
     */
    private void addResources(Player player){
        
    }
}
