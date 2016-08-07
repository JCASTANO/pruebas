package com.bullying.util;

import com.bullying.exception.ValidatorException;

public class Validator 
{
	private Validator() {
	}
	
	public static void validateNullEmpty(Object object, String mensaje)
	{
		if(object == null || "".equals(object) )
		{
			throw new ValidatorException(mensaje);
		}
	}
}
