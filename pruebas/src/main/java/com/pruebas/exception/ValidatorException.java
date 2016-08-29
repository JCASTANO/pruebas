package com.pruebas.exception;

/**
 * 
 * @author juan.castano
 *
 */
public class ValidatorException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param message
	 */
	public ValidatorException(String message)
	{
		super(message);
	}

}
