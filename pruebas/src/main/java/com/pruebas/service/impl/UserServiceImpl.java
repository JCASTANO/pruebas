package com.pruebas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebas.dto.UserDto;
import com.pruebas.model.TypeProfile;
import com.pruebas.model.User;
import com.pruebas.repository.UserRepository;
import com.pruebas.service.UserService;

/**
 * 
 * @author juan.botero
 *
 */
@Service
public class UserServiceImpl implements UserService 
{

	@Autowired
	UserRepository userRepository;
	
	/**
	 * @author juan.botero
	 */
	@Override
	public UserDto getUserSecurity(UserDto userDto) {
		User userToSave =  userRepository.getUserByIdUserSocial(userDto.getId());
		if(userToSave == null)
		{
			userToSave = User.createUserFromUserDto(userDto);
			TypeProfile typeProfile = (TypeProfile) userRepository.buscarPorId(TypeProfile.class, TypeProfile.ID_PROFILE_GENERAL);
			userToSave.setProfile(typeProfile);
			userRepository.guardar(userToSave);
		}		
		return userDto;
	}
}
