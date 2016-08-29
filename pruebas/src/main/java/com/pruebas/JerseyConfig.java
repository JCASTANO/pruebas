package com.pruebas;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.pruebas.controller.UserController;

/**
 * 
 * @author juan.castano
 *
 */
@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	
	/**
	 * @author juan.castano
	 */
    public JerseyConfig() {
    	register(AppExceptionMapper.class);
        register(UserController.class);
    }
}
