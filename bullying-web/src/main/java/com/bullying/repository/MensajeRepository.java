package com.bullying.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bullying.model.Mensaje;

@Repository
public class MensajeRepository {
	
	@Autowired
    private GenericRepository genericRepository;
	
	public Mensaje findOne(Long id){
        return (Mensaje) genericRepository.findOne(Mensaje.class,id);
    }

    public Mensaje save(Mensaje mensaje){
        return (Mensaje) genericRepository.save(mensaje);
    }
    
    public void delete(Mensaje mensaje){
    	genericRepository.delete(mensaje);
    }
}
