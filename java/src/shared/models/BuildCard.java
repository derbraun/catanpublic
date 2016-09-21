/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.models;

import java.util.ArrayList;
import org.json.JSONObject;
import shared.definitions.ResourceType;

/**
 *
 * @author daniel
 */
public class BuildCard extends Card {
    
    private ArrayList<ResourceType> roadCost;
    private ArrayList<ResourceType> settleCost;
    private ArrayList<ResourceType> cityCost;
    private ArrayList<ResourceType> devCost;

    /**
     * Default Constructor
     * Not drawable
     */
    public BuildCard() {
    }

    /**
     * Constructor that takes a JSON and creates a loaded Build Card
     * Not drawable
     * @param cardObject 
     */
    public BuildCard(JSONObject cardObject) {
        super(cardObject);
        drawable = false;
    }
    
    /**
     * Checks to see if resources provided is enough to build a road
     * @param resources
     * @return if resources provided matches the road cost
     */
    public boolean canBuyRoad(ArrayList<ResourceType> resources){
        return true;
    
    }
    
    /**
     * Checks to see if resources provided is enough to build a settlement
     * @param resources
     * @return if resources provided matches the settle cost
     */
    public boolean canBuySettle(ArrayList<ResourceType> resources){
        return true;
    
    }
    /**
     * Checks to see if resources provided is enough to build a city
     * @param resources
     * @return if resources provided matches the city cost
     */
    public boolean canBuyCity(ArrayList<ResourceType> resources){
        return true;
    
    }
    /**
     * Checks to see if resources provided is enough to buy a development card
     * @param resources
     * @return if resources provided matches the development cost
     */
    public boolean canBuyDev(ArrayList<ResourceType> resources){
        return true;
    
    }

    public ArrayList<ResourceType> getRoadCost() {
        return roadCost;
    }

    public void setRoadCost(ArrayList<ResourceType> roadCost) {
        this.roadCost = roadCost;
    }

    public ArrayList<ResourceType> getSettleCost() {
        return settleCost;
    }

    public void setSettleCost(ArrayList<ResourceType> settleCost) {
        this.settleCost = settleCost;
    }

    public ArrayList<ResourceType> getCityCost() {
        return cityCost;
    }

    public void setCityCost(ArrayList<ResourceType> cityCost) {
        this.cityCost = cityCost;
    }

    public ArrayList<ResourceType> getDevCost() {
        return devCost;
    }

    public void setDevCost(ArrayList<ResourceType> devCost) {
        this.devCost = devCost;
    }
    
    
}
