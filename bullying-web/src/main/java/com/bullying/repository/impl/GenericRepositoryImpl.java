package com.bullying.repository.impl;

import static com.bullying.util.MensajeConstants.CLASE_NULL;
import static com.bullying.util.MensajeConstants.ENTITY_NULL;
import static com.bullying.util.MensajeConstants.ID_NULL;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.bullying.repository.GenericRepository;

@Transactional
public class GenericRepositoryImpl implements GenericRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public Object buscarPorId(Class clase,Object id) {
		Assert.notNull(id, ID_NULL);
		Assert.notNull(clase, CLASE_NULL);
		return entityManager.find(clase, id);
	}

	public Object guardar(Object entity) {
		Assert.notNull(entity, ENTITY_NULL);
		return entityManager.merge(entity);
	}

	public void borrar(Object entity) {
		Assert.notNull(entity, ENTITY_NULL);
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}
	
	@Override
	public void insertar(Object entity) {
		Assert.notNull(entity, ENTITY_NULL);
		entityManager.persist(entity);
	}
	
}
