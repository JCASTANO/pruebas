package com.pruebas.service;

import com.pruebas.dto.UserDto;

/**
 * 
 * @author juan.botero
 *
 */
@FunctionalInterface
public interface UserService {

	/**
	 * 
	 * @param user
	 * @return
	 */
	UserDto getUserSecurity(UserDto user);
}
