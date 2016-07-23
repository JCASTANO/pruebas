package com.bullying.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bullying.model.Mensaje;
import com.bullying.repository.MensajeRepository;

@Service
public class MensajeService {

	@Autowired
    private MensajeRepository mensajeRepository;

    public Iterable<Mensaje> findAll(){
        return mensajeRepository.findAll();
    }

    public Mensaje findById(Long id){
        return mensajeRepository.findOne(id);
    }

    public Mensaje save(Mensaje person){
        return mensajeRepository.save(person);
    }
}
