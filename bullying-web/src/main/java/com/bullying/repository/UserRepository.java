package com.bullying.repository;

import com.bullying.model.User;

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
