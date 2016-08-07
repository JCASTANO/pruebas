package com.bullying.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bullying.model.TypeProfile;
import com.bullying.model.User;
import com.bullying.repository.UserRepository;
import com.bullying.service.UserService;

@Service
public class UserServiceImpl implements UserService 
{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUserSecurity(User user) {
		User userInRepository =  (User) userRepository.buscarPorId(User.class, user.getId());
		if(userInRepository == null)
		{
			TypeProfile typeProfile = (TypeProfile) userRepository.buscarPorId(TypeProfile.class, TypeProfile.ID_PROFILE_GENERAL);
			user.setProfile(typeProfile);
			userRepository.guardar(user);
			userInRepository = user;
		}		
		return userInRepository;
	}
}
