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

    public Mensaje buscarPorId(Long id){
        return mensajeRepository.buscarPorId(id);
    }

    public Mensaje guardar(Mensaje mensaje){
        return mensajeRepository.guardar(mensaje);
    }
    
    public void borrar(Mensaje mensaje){
        mensajeRepository.borrar(mensaje);
    }
}
