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
import com.bullying.security.UserSession;
import com.bullying.service.MensajeService;

@Component
@Path("/private/mensajeController")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MensajeController {
	
	@Autowired
	private MensajeService mensajeService;
	
	@Autowired
	private UserSession userSession;
    
	@GET
    @Path("buscarPorId")
    public Mensaje buscarPorId(@QueryParam("id") Long id) {
       return mensajeService.buscarPorId(id);
    }
	
	@POST
    @Path("guardar")
    public Mensaje guardar(Mensaje mensaje) {
        return mensajeService.guardar(mensaje);
    }
	
	@POST
    @Path("borrar")
    public void borrar(Mensaje mensaje) {
        mensajeService.borrar(mensaje);
    }
	
	@GET
    @Path("pruebaSeguridad")
    public void pruebaSeguridad() {
        System.out.println(userSession.getUserSession().getName());
    }
}
