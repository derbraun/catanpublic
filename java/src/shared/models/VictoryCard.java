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
public class VictoryCard extends DevCard {
    protected int pointWorth;
    
    
    /**
     * Default Constructor
     */
    public VictoryCard(){}
    
    /**
     * Constructor that takes a JSON object and creates a new Victory Card out of it
     * @param card 
     */
    public VictoryCard(JSONObject card){
        
    }
    /**
     * overrided version of playCard
     * Plays the card and activates its effect on the map 
     * (Victory Points are added)
     *
     * @pre card is in a player's hand and is at end of game
     * @post victory points are added to player
     * @param player
     */
    @Override
    public void playCard(Player player) {
       
    }
    
    /**
     * overrided version of canPlayCard
     * Checks to make sure the card is a valid card
     * @pre end of game
     * @return boolean on whether the card can be played
     */
    @Override
    public boolean canPlayCard() {
        return true;
    }

    public int getPointWorth() {
        return pointWorth;
    }

    public void setPointWorth(int pointWorth) {
        this.pointWorth = pointWorth;
    }
    
}
