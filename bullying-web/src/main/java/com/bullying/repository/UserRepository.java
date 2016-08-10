package com.bullying.repository;

import com.bullying.model.User;


public interface UserRepository extends GenericRepository{

	User getUserByIdUserSocial(long idUserSocial);

	
}
