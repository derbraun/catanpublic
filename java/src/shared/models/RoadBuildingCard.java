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
public class RoadBuildingCard extends ProgressCard {
     /**
     * Default Constructor
     */
    public RoadBuildingCard(){}
    
    /**
     * Constructor that takes a JSON object and creates a new Road Building Card out of it
     * @param card 
     */
    public RoadBuildingCard(JSONObject card){
        
    }
    /**
     * overrided version of playCard
     * Plays the card and activates its effect on the map 
     * (builds 2 roads for free)
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
     * Calls the Singleton to build 2 roads (Game calls the canBuild)
     * @pre there are 2 places user can build roads at
     * @param player 
     */
    private void buildRoads(Player player){
        
    }
}
