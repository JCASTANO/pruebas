package com.bullying.repository.impl;

import static com.bullying.util.Constants.CLASE_NULL;
import static com.bullying.util.Constants.CONSTANTS;
import static com.bullying.util.Constants.ENTITY_NULL;
import static com.bullying.util.Constants.ID_NULL;

import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.bullying.repository.GenericRepository;

@Repository
@Transactional
public class GenericRepositoryImpl implements GenericRepository {

	@PersistenceContext
	private EntityManager entityManager;
	private ResourceBundle constantsBundle = ResourceBundle.getBundle(CONSTANTS);
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public Object buscarPorId(Class clase,Object id) {
		Assert.notNull(id, constantsBundle.getString(ID_NULL));
		Assert.notNull(clase, constantsBundle.getString(CLASE_NULL));
		return entityManager.find(clase, id);
	}

	public Object guardar(Object entity) {
		Assert.notNull(entity, constantsBundle.getString(ENTITY_NULL));
		return entityManager.merge(entity);
	}

	public void borrar(Object entity) {
		Assert.notNull(entity, constantsBundle.getString(ENTITY_NULL));
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}
}
