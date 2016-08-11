package com.bullying.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.bullying.repository.GenericRepository;

/**
 * 
 * @author <a href="mailto:estebancastanorincon@gmail.com">Juan Esteban Castano</a>
 * @project bullying-web
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
	 * @see com.bullying.repository.GenericRepository#buscarPorId(java.lang.Class, java.lang.Object)
	 */
	@SuppressWarnings({"unchecked", "rawtypes" })
	public Object buscarPorId(Class clase,Object id) {
		return entityManager.find(clase, id);
	}

	/**
	 * 
	 * @author <a href="mailto:estebancastanorincon@gmail.com">Juan Esteban Castano</a>
	 * @since Aug 11, 2016
	 * @see com.bullying.repository.GenericRepository#guardar(java.lang.Object)
	 */
	public Object guardar(Object entity) {
		return entityManager.merge(entity);
	}
	
	
}
