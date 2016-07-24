package com.bullying.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class GenericRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public Object findOne(Class clase,Object id) {
		return entityManager.find(clase, id);
	}

	public Object save(Object entity) {
		return entityManager.merge(entity);
	}

	public void delete(Object entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}
}
