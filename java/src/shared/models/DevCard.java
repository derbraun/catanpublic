/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.models;

/**
 *
 * @author daniel
 */
public abstract class DevCard extends Card{
    /**
     * Default constructor
     * drawable is set to true
     */
    public DevCard(){ }    
    
    /**
     * Plays the card and activates its effect on the map/player
     *
     * @pre card is in a player's hand and is a valid card
     * @post card's effect, based off of it's subclass, is invoked on the game
     * @param player 
     */
    public abstract void playCard(Player player);
    
    /**
     * Checks to make sure the card is a valid card
     * @pre player hasn't played a development card yet 
     * @return boolean on whether the card can be played
     */
    public abstract boolean canPlayCard();
    
}
