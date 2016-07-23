package com.bullying.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bullying.model.Mensaje;
import com.bullying.repository.MensajeRepository;

@Service
public class MensajeService {

	@Autowired
    private MensajeRepository mensajeRepository;

    public Mensaje findOne(Long id){
        return mensajeRepository.findOne(id);
    }

    public Mensaje save(Mensaje mensaje){
        return mensajeRepository.save(mensaje);
    }
    
    public void delete(Mensaje mensaje){
        mensajeRepository.delete(mensaje);
    }
}
