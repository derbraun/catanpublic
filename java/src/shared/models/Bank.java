/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.models;

import shared.definitions.HexType;

/**
 *
 * @author daniel
 */
public class Bank {
    private DevelopmentCardManager deck;
    private ResourceManager resources;
    
    public Bank(){
        
    }
    
    /**
     * Takes a random devCard from the deck and returns it to player
     * @return devCard
     */
    public DevCard giveDevCard(){
        
        return null;
    }
    
    /**
     * Adds Hex Type to the Bank
     * @param type
     */
    public void addResourceCard(HexType type){
        
    }
    
    /**
     *Takes in a hex type, decrements that type in the bank and returns original type
     * @param type
     * @return
     */
    public HexType giveResourceCard(HexType type){
        return type;
    }
    
}
