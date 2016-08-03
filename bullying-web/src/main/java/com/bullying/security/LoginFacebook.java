package com.bullying.security;

import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bullying.model.User;

@Service
public class LoginFacebook 
{

	private static final String URL_FACEBOOK_DATA = "https://graph.facebook.com/me?access_token={token}&fields=email,name";

	Cookie getCookie(HttpServletRequest httpRequest) 
	{
		Cookie[] cookies = httpRequest.getCookies();
		Optional<Cookie> optional =Arrays.stream(cookies).filter(c -> "Facebook-Token".equals(c.getName())).findFirst();
		Cookie cookie = null;
		if(optional.isPresent()) {
		    cookie = optional.get();
		}
		return cookie;
	}

	User getUser(HttpServletRequest httpRequest) {
		Cookie cookie = getCookie(httpRequest);		
		RestTemplate restTemplate = new RestTemplate();
	    User user = restTemplate.getForObject(URL_FACEBOOK_DATA, User.class,cookie.getValue());
		return user;
	}

}
