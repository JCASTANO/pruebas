package com.bullying.security;

import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bullying.dto.UserDto;
import com.bullying.service.UserService;
import com.bullying.util.Validator;

/**
 * 
 * @author juan.botero
 *
 */
@Service
public class LoginFacebook {

	private static final String ACCESO_PROHIBIDO = "Acceso prohibido";
	public static final String FACEBOOK_TOKEN = "Facebook-Token";
	private static final String URL_FACEBOOK_DATA = "https://graph.facebook.com/me?access_token={token}&fields=email,name";
	
	@Autowired
	UserService userService;
	
	/**
	 * @author juan.botero
	 */
	public LoginFacebook()
	{
		// Default constructor
	}
	
	/**
	 * @author juan.botero
	 */
	public LoginFacebook(UserService userService)
	{
		this.userService = userService;
	}

	/**
	 * @author juan.botero
	 */
	public Cookie getCookie(HttpServletRequest httpRequest) {
		Cookie cookie = null;
		Cookie[] cookies = httpRequest.getCookies();
		Validator.validateNullEmpty(cookies, ACCESO_PROHIBIDO);
		Optional<Cookie> optional =Arrays.stream(cookies).filter(c -> FACEBOOK_TOKEN.equals(c.getName())).findFirst();
		if(optional.isPresent()) {
		    cookie = optional.get();
		}
		return cookie;
	}

	/**
	 * @author juan.botero
	 */
	public UserDto getUser(HttpServletRequest httpRequest) {
		Cookie cookie = getCookie(httpRequest);
		if(cookie == null)
		{
			throw new WebApplicationException(ACCESO_PROHIBIDO, Response.Status.FORBIDDEN);
		}
		UserDto user = getUserFromFacebook(cookie);	    
		return userService.getUserSecurity(user);
	}

	/**
	 * @author juan.botero
	 */
	public UserDto getUserFromFacebook(Cookie cookie) {
		RestTemplate restTemplate = new RestTemplate();
	    return restTemplate.getForObject(URL_FACEBOOK_DATA, UserDto.class,cookie.getValue());
	}
}
