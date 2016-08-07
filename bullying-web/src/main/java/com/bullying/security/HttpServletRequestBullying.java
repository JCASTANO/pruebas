package com.bullying.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.bullying.model.User;

public class HttpServletRequestBullying extends HttpServletRequestWrapper{

	private User userSession; 
	
	public HttpServletRequestBullying(HttpServletRequest request, User user) {
		super(request);
		userSession = user;
	}

	public User getUserSession() {
		return userSession;
	}

}
