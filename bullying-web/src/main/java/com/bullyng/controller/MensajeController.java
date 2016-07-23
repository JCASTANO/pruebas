package com.bullyng.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bullying.model.Mensaje;
import com.bullying.service.MensajeService;

@Component
@Path("/mensajeController")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MensajeController {
	
	@Autowired
	private MensajeService mensajeService;
    
	@GET
    @Path("getMensaje")
    public Mensaje getMensaje() {
        Mensaje mensaje = new Mensaje();
        mensaje.setId(1L);
        mensaje.setContenido(Mensaje.HOLA_MUNDO);
        return mensaje;
    }
	
	@POST
    @Path("saveMensaje")
    public Mensaje saveMensaje(Mensaje mensaje) {
        return mensaje;
    }
}
