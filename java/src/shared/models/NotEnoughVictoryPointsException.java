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
public class NotEnoughVictoryPointsException extends Exception {

    /**
     * Creates a new instance of <code>NotEnoughVictoryPointsException</code> without detail message.
     */
    public NotEnoughVictoryPointsException() {
    }

    /**
     * Constructs an instance of <code>NotEnoughVictoryPointsException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public NotEnoughVictoryPointsException(String msg) {
        super(msg);
    }
}
