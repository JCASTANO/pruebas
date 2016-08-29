package com.pruebas.repository.impl;


import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pruebas.model.User;
import com.pruebas.repository.UserRepository;

/**
 * 
 * @author juan.castano
 *
 */
@Repository(value="userRepositoryImpl")
public class UserRepositoryImpl extends GenericRepositoryImpl implements UserRepository  
{

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByIdUserSocial(long idUserSocial) 
	{
		String jpql = "SELECT U FROM User U WHERE U.idUserSocial = :idUserSocial";
		Query query = this.entityManager.createQuery(jpql, User.class);
		query.setParameter("idUserSocial", idUserSocial);
		List<User> users = query.getResultList();
		return !users.isEmpty() ? users.get(0) : null;
	}
	
}
