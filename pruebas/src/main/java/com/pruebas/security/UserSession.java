package com.pruebas.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.pruebas.dto.UserDto;

/**
 * 
 * @author juan.botero
 *
 */
@Service
public class UserSession 
{
	public UserDto getUserSession() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();		
		return (UserDto) request.getAttribute("user");
	}
}
