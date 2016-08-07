package com.bullying.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bullying.model.Mensaje;
import com.bullying.repository.MensajeRepository;
import com.bullying.service.MensajeService;

@Service
public class MensajeServiceImpl implements MensajeService {

	@Autowired
    private MensajeRepository mensajeRepository;

	@Override
    public Mensaje buscarPorId(Long id){
        return (Mensaje) mensajeRepository.buscarPorId(Mensaje.class, id);
    }

	@Override
    public Mensaje guardar(Mensaje mensaje){
        return (Mensaje) mensajeRepository.guardar(mensaje);
    }
    
	@Override
    public void borrar(Mensaje mensaje){
        mensajeRepository.borrar(mensaje);
    }
}
