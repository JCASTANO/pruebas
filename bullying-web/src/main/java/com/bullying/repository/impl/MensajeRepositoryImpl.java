package com.bullying.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bullying.model.Mensaje;
import com.bullying.repository.GenericRepository;
import com.bullying.repository.MensajeRepository;

@Repository
public class MensajeRepositoryImpl implements MensajeRepository {
	
	@Autowired
    private GenericRepository genericRepository;
	
	public Mensaje buscarPorId(Long id){
        return (Mensaje) genericRepository.buscarPorId(Mensaje.class,id);
    }

    public Mensaje guardar(Mensaje mensaje){
        return (Mensaje) genericRepository.guardar(mensaje);
    }
    
    public void borrar(Mensaje mensaje){
    	genericRepository.borrar(mensaje);
    }
}
