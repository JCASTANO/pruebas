package com.bullying.repository.impl;

import org.springframework.stereotype.Repository;

import com.bullying.repository.UserRepository;

@Repository(value="userRepositoryImpl")
public class UserRepositoryImpl extends GenericRepositoryImpl implements UserRepository  {
	

}
