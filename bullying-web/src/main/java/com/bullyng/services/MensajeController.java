package com.bullyng.services;

import java.math.BigDecimal;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.bullying.dto.Mensaje;

@Component
@Path("/mensajeCtrl")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MensajeController {
    
	@GET
    @Path("getMensaje")
    public Mensaje getMensaje() {
        Mensaje mensaje = new Mensaje();
        mensaje.setContenido(Mensaje.HOLA_MUNDO);
        return mensaje;
    }
	
	@POST
    @Path("saveMensaje")
    public Mensaje saveMensaje(Mensaje mensaje) {
		mensaje.setId(BigDecimal.ONE.longValue());
        return mensaje;
    }
}
