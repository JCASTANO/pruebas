package com.pruebas.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.pruebas.repository.GenericRepository;

/**
 * 
 * @author <a href="mailto:estebancastanorincon@gmail.com">Juan Esteban Castano</a>
 * @project pruebas
 * @class GenericRepositoryImpl
 * @since Aug 11, 2016
 *
 */
@Transactional
public class GenericRepositoryImpl implements GenericRepository {

	@PersistenceContext
	protected EntityManager entityManager; 
	
	/**
	 * 
	 * @author <a href="mailto:estebancastanorincon@gmail.com">Juan Esteban Castano</a>
	 * @since Aug 11, 2016
	 * @see com.pruebas.repository.GenericRepository#buscarPorId(java.lang.Class, java.lang.Object)
	 * @return Object
	 * @param clase
	 * @param id
	 */
	@SuppressWarnings({"unchecked", "rawtypes" })
	public Object buscarPorId(Class clase,Object id) {
		return entityManager.find(clase, id);
	}

	/**
	 * 
	 * @author <a href="mailto:estebancastanorincon@gmail.com">Juan Esteban Castano</a>
	 * @since Aug 11, 2016
	 * @see com.pruebas.repository.GenericRepository#guardar(java.lang.Object)
	 * @param entity
	 * @return entity
	 */
	public Object guardar(Object entity) {
		return entityManager.merge(entity);
	}
}
