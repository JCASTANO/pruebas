package com.bullying.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.bullying.repository.GenericRepository;

@Transactional
public class GenericRepositoryImpl implements GenericRepository {

	@PersistenceContext
	protected EntityManager entityManager; 
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public Object buscarPorId(Class clase,Object id) {
		return entityManager.find(clase, id);
	}

	public Object guardar(Object entity) {
		return entityManager.merge(entity);
	}
	
	
}
