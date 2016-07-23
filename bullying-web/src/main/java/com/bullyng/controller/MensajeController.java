package com.bullyng.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    public Mensaje getMensaje(@QueryParam("id") Long id) {
       return mensajeService.findOne(id);
    }
	
	@POST
    @Path("saveMensaje")
    public Mensaje saveMensaje(Mensaje mensaje) {
        return mensajeService.save(mensaje);
    }
	
	@POST
    @Path("deleteMensaje")
    public void deleteMensaje(Mensaje mensaje) {
        mensajeService.delete(mensaje);
    }
}
