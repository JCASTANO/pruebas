package com.bullying.service;

import com.bullying.dto.UserDto;

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
