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
public class LargestArmy extends VictoryCard{
        private Player player;
    
    /**
     * Adjusts the owner of this card
     * This may not change depending on the player's army size
     * @param p
     * @return the player who now owns this card
     */
    
    public Player adjustOwner(Player p){
        if(p.getDevelopmentCards().getArmySize() > player.getDevelopmentCards().getArmySize())
            player = p;
        
        return player;  
    }
}
