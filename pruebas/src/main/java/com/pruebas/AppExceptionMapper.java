package com.pruebas;

import static com.pruebas.util.Constants.ARCHIVO_CONSTANTS;
import static com.pruebas.util.Constants.ERROR_SERVIDOR;
import static com.pruebas.util.Constants.VALOR;
import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

import java.util.HashMap;
import java.util.ResourceBundle;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 
 * @author juan.castano
 *
 */
@Provider
public class AppExceptionMapper implements ExceptionMapper<Throwable> {
	
	private static final Logger LOGGER = LogManager.getLogger(AppExceptionMapper.class);
	private ResourceBundle constantsBundle = ResourceBundle.getBundle(ARCHIVO_CONSTANTS);
	
	@Override
	public Response toResponse(Throwable e) {				
		LOGGER.error(ResourceBundle.getBundle(ARCHIVO_CONSTANTS).getString(ERROR_SERVIDOR), e);
		HashMap<String, Object> respuesta = new HashMap<>();
		respuesta.put(constantsBundle.getString(VALOR), constantsBundle.getString(ERROR_SERVIDOR));
		return  Response.status(INTERNAL_SERVER_ERROR)
                .entity(respuesta)
                .build();	
	}
}
