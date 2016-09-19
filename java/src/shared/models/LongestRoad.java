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
public class LongestRoad extends VictoryCard{
    private Player player;
    
    /**
     * Adjusts the owner of this card
     * This may not change depending on the player's road length
     * @param p
     * @return the player who now owns this card
     */
    
    public Player adjustOwner(Player p){
       
        return player;  
    }    
    
}

