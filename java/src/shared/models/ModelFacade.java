/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.models;

import java.util.ArrayList;
import org.json.JSONObject;
import shared.definitions.DevCardType;
import shared.definitions.PlayerIndex;
import shared.definitions.ResourceType;
import shared.definitions.TradeMeans;
import shared.locations.EdgeLocation;
import shared.locations.VertexLocation;
import shared.models.map.BuildingNotUpgradableException;
import shared.models.map.InvalidBuildingPlacementException;
import shared.models.map.InvalidRoadPlacementException;

/**
 *
 * @author daniel
 */
interface ModelFacade {
     /**
     * Takes a JSON object, parses it, and sends it out to different locations in the model
     */
    public abstract void updateGame(JSONObject json);

    /**
     * updates the turnTracker
     * @param turn
     * @return whether it updated or not
     */
    public abstract boolean updateTurn(JSONObject turn);
    /**
     * adds player to players
     * @return if added 
     */
    public abstract boolean addPlayer();
    
    /**
     * Rolls the dice. 
     * @return dice roll 
     */
    public abstract int rollDice();
    
    /**
     * Moves the robber and allows the current player to rob a player
     * @pre a 7 is rolled or a knight is played
     * @post the robber is at a new location and marked on the map
     */
    public abstract void moveRobber();
    
    /**
     * Places a road at location
     * calls canBuildRoad on Map of it fails, throws exception
     * @param loc
     * @throws InvalidRoadPlacementException 
     * @post current player has new road on map
     */
    public abstract void placeRoad(EdgeLocation loc) throws InvalidRoadPlacementException;
    
    /**
     * Places a settlement at location
     * calls canBuildSettlement on Map of it fails, throws exception
     * @param loc
     * @throws InvalidBuildingPlacementException 
     * @post current player has a new settlement on map
     */
    public abstract void placeSettlement(VertexLocation loc) throws InvalidBuildingPlacementException;
    /**
     * Places a city where a settlement is
     * calls canUpgradeSettlement on Map if ti fails, throws exception
     * @param loc
     * @throws BuildingNotUpgradableException 
     * @post current player has new city on map
     */
    public abstract void upgradeSettlement(VertexLocation loc) throws BuildingNotUpgradableException;
    
    /**
     * Adds a development card at random to current player
     * @throws NoDevCardsAvailableException
     * @post player has new development card
     */
    public abstract void buyDevCard() throws NoDevCardsAvailableException;
    
    /**
     * Updates the chat with a new message
     * @param player
     * @param message
     * @post new post in chat
     */
    public abstract void updateChat(Player player, String message);
    
    /**
     * Updates the Game log
     * @param player
     * @param message
     * @post new post in game log
     */
    public abstract void updateLog(Player player, String message);
    /**
     * Updates the owner of the Longest Road
     * @param player
     * @post new owner of the longest road
     */
    public abstract void updateLongestRoad(PlayerIndex player);
    
    /**
     * Updates the owner of the Largest Army
     * @param player 
     * @post new owner of the largest army
     */
    public abstract void updateLargestArmy(PlayerIndex player);
    /**
     * Distributes the resources to all players on hex selected
     * @param roll
     * @post added resources to all players with cities or settlement on hexes producing resources this turn.
     */
    public abstract void distributeResources(int roll);
    
    /**
     * Plays a development card from a player's hand
     * @param player
     * @param dev 
     * @post card is removed from player's hand and effect is used
     */
    public abstract void playDevCard(Player player, DevCardType dev);
    /**
     * Checks to see if player can trade
     * 
     * @param player1
     * @param means
     * @return whether the player can trade by selected means
     */
    public abstract boolean canTrade(Player player1, TradeMeans means);
    
    /**
     * Trades resource 1 from player 1 with resource 2 from player 2
     * @param player1
     * @param player2
     * @param resource1
     * @param resource2 
     */
    public abstract void playerTrade(Player player1, Player player2, ArrayList<ResourceType> resource1, ArrayList<ResourceType> resource2);
    /**
     * Trades resources via marintime trade for quantity of selected resource
     * @param player
     * @param resource
     * @param quantity 
     */
    public abstract void marintimeTrade(Player player, ResourceType resource, int quantity);
    /**
     * Trades resources via bankTrade for quantity of selected resource
     * @param player
     * @param resource
     * @param quantity 
     */
    public abstract void bankTrade(Player player, ResourceType resource, int quantity);
    
    /**
     * 
     * @throws NotEnoughVictoryPointsException
     * @pre 1 player must have at least 10 victory points
     * @return player with highest victory point totals 
     */
    public abstract Player endGame() throws NotEnoughVictoryPointsException;
}
