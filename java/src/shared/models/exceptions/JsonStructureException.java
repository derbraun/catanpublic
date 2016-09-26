/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.models.exceptions;

/**
 * Thrown when the JsonObject being processed does not have the
 * expected structure.
 * 
 * @author John Larson
 */
public class JsonStructureException extends Exception {
	
	public JsonStructureException() {
		super();
	}
	
	public JsonStructureException(String message) {
		super(message);
	}
	
	public JsonStructureException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public JsonStructureException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public JsonStructureException(Throwable cause) {
		super(cause);
	}
	
}
