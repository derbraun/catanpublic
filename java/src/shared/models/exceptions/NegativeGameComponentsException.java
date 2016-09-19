/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.models.exceptions;

/**
 * It's impossible to have negative tokens or cards, so this Exception
 * is thrown whenever an operation would result in a negative number of
 * those things.
 * 
 * @author John Larson
 */
public class NegativeGameComponentsException extends Exception {
	
}
