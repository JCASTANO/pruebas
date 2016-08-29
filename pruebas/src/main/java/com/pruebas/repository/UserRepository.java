package com.pruebas.repository;

import com.pruebas.model.User;

/**
 * 
 * @author juan.castano
 *
 */
public interface UserRepository extends GenericRepository{

	/**
	 * 
	 * @param idUserSocial
	 * @return
	 */
	User getUserByIdUserSocial(long idUserSocial);

	
}
