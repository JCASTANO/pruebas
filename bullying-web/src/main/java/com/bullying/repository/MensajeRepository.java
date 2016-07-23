package com.bullying.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bullying.model.Mensaje;

@Repository
public interface MensajeRepository extends CrudRepository<Mensaje,Long> {

}
