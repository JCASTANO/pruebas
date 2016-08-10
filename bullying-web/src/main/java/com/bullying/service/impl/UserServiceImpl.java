package com.bullying.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bullying.dto.UserDto;
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
	public UserDto getUserSecurity(UserDto userDto) {
		User userToSave =  userRepository.getUserByIdUserSocial(userDto.getId());
		if(userToSave == null)
		{
			userToSave = User.createUserFromUserDto(userDto);
			TypeProfile typeProfile = (TypeProfile) userRepository.buscarPorId(TypeProfile.class, TypeProfile.ID_PROFILE_GENERAL);
			userToSave.setProfile(typeProfile);
			User userSaved =  (User) userRepository.guardar(userToSave);
			userDto.setIdBullying(userSaved.getId());
		}		
		return userDto;
	}
}
