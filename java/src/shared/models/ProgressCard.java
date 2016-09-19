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
public abstract class ProgressCard extends DevCard{
     /**
     * Default Constructor
     */
    public ProgressCard(){}
    
    /**
     * Constructor that takes a JSON object and creates a new ProgressCard out of it
     * @param card 
     */
    public ProgressCard(JSONObject card){
        
    }
    /**
     * Plays the card and activates its effect on the map 
     *
     * @pre card is in a player's hand and is a valid card
     * @post card's effect, based off of it's subclass, is invoked on the game
     * @param player 
     */
    @Override
    public abstract void playCard(Player player); 

    /**
     * Checks to make sure the card is a valid card
     * @pre player hasn't played a development card yet
     * @return boolean on whether the card can be played
     */
    @Override
    public abstract boolean canPlayCard();
}
