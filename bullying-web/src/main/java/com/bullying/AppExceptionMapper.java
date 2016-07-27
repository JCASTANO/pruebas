package com.bullying;

import static com.bullying.util.Constants.CONSTANTS;
import static com.bullying.util.Constants.ERROR_SERVIDOR;
import static com.bullying.util.Constants.VALOR;
import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;
import java.util.HashMap;
import java.util.ResourceBundle;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Provider
public class AppExceptionMapper implements ExceptionMapper<Throwable> {
	
	private static final Logger LOGGER = LogManager.getLogger(AppExceptionMapper.class);
	private ResourceBundle constantsBundle = ResourceBundle.getBundle(CONSTANTS);
	
	@Override
	public Response toResponse(Throwable  exception) {				
		LOGGER.error(constantsBundle.getString(ERROR_SERVIDOR), exception);
		HashMap<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put(constantsBundle.getString(VALOR), constantsBundle.getString(ERROR_SERVIDOR));
		return  Response.status(INTERNAL_SERVER_ERROR)
                .entity(respuesta)
                .build();	
	}
}
