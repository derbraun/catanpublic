/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.models.exceptions;

/**
 * Thrown when a String which is supposed to represent a color cannot
 * be interpreted as a hexadecimal color.
 * 
 * @author John Larson
 */
public class ColorParseException extends Exception {
	
	public ColorParseException() {
		super();
	}
	
	public ColorParseException(String message) {
		super(message);
	}
	
	public ColorParseException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ColorParseException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public ColorParseException(Throwable cause) {
		super(cause);
	}
	
}
