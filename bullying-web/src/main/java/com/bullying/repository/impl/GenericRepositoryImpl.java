package com.bullying.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.bullying.repository.GenericRepository;

/**
 * 
 * @author juan.castano
 *
 */
@Transactional
public class GenericRepositoryImpl implements GenericRepository {

	@PersistenceContext
	protected EntityManager entityManager; 
	
	/**
	 * @author juan.castano
	 */
	@SuppressWarnings({"unchecked", "rawtypes" })
	public Object buscarPorId(Class clase,Object id) {
		return entityManager.find(clase, id);
	}

	/**
	 * @author juan.castano
	 */
	public Object guardar(Object entity) {
		return entityManager.merge(entity);
	}
	
	
}
