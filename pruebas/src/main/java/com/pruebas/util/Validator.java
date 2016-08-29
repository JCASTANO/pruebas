package com.pruebas.util;

import com.pruebas.exception.ValidatorException;

/**
 * 
 * @author juan.castano
 *
 */
public class Validator 
{
	private Validator() {
	}
	
	/**
	 * 
	 * @param object
	 * @param mensaje
	 */
	public static void validateNullEmpty(Object object, String mensaje)
	{
		if(object == null || "".equals(object) )
		{
			throw new ValidatorException(mensaje);
		}
	}
}
