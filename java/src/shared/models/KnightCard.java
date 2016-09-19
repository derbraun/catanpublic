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
public class KnightCard extends DevCard{

    /**
     * Default Constructor
     */
    public KnightCard(){}
    
    /**
     * Constructor that takes a JSON object and creates a new Knight out of it
     * @param card 
     */
    public KnightCard(JSONObject card){
        
    }
    /**
     * overrided version of playCard
     * Plays the card and activates its effect on the map 
     * (moves the robber)
     *
     * @pre card is in a player's hand and is a valid card
     * @post card's effect, based off of it's subclass, is invoked on the game
     * @param player 
     */
    @Override
    public void playCard(Player player) {
        
    }

    /**
     * Checks to make sure the card is a valid card
     * @pre player hasn't played a development card yet
     * @return boolean on whether the card can be played
     */
    @Override
    public boolean canPlayCard() {
        return true;
    }
    
    /**
     * Invokes the Singleton to then move the robber
     * 
     * @pre called from play card
     * @post robber is moved to a new location and the player has stolen
     * @param player
     */
    private void moveRobber(Player player){
        
    }
    
    
}
