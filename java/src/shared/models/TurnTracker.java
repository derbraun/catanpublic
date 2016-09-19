/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.models;

import org.json.JSONObject;
import shared.definitions.PlayerIndex;
import shared.definitions.TurnStatus;

/**
 *
 * @author daniel
 */
public class TurnTracker {
    private PlayerIndex currentTurn;
    private TurnStatus status;
    private PlayerIndex longestRoad;
    private PlayerIndex largestArmy;
    
    /**
     * Default Constructor
     */
    public TurnTracker(){}
    
    /**
     * Takes JSON object and creates a TurnTracker object from it.
     */
    public TurnTracker(JSONObject obj){
    
    }
    
    /**
     * starts the next turn.
     * If next turn would start the next round, updates the round
     */
    public void startNextTurn(){
        
    }

    public PlayerIndex getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(PlayerIndex currentTurn) {
        this.currentTurn = currentTurn;
    }

    public TurnStatus getStatus() {
        return status;
    }

    public void setStatus(TurnStatus status) {
        this.status = status;
    }

    public PlayerIndex getLongestRoad() {
        return longestRoad;
    }

    public void setLongestRoad(PlayerIndex longestRoad) {
        this.longestRoad = longestRoad;
    }

    public PlayerIndex getLargestArmy() {
        return largestArmy;
    }

    public void setLargestArmy(PlayerIndex largestArmy) {
        this.largestArmy = largestArmy;
    }
    
    
    
}
