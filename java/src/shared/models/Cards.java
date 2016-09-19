/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.models;

import org.json.JSONObject;
/**
 * Holds information about all cards used in the game
 * Acts as parent object for both the buildCard and the DevCard
 * @author daniel
 */
public class Cards {
    protected String name;
    protected boolean drawable;
    
    
    /**
     * Default Constructor that creates an empty card
     * @post an empty card that can now be edited at a later point in time
     */
    public Cards(){
    }
    /**
     * @pre cardObject is a valid JSON Object
     * @post a card that can now be used
     * @param cardObject 
     */
    public Cards(JSONObject cardObject){
        
    }
    
    public boolean isDrawable(){
        return drawable;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    private void setDrawable(boolean drawable) {
        this.drawable = drawable;
    }

    public String getName() {
        return name;
    }
       
    
}
