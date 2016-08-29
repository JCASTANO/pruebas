package com.pruebas.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.pruebas.dto.UserDto;

/**
 * 
 * @author juan.botero
 *
 */
public class FilterSecurity implements Filter 
{

	@Autowired
	private LoginFacebook loginFacebook;

	/**
	 * @param request
	 * @param response
	 * @param chain
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		UserDto user = loginFacebook.getUser(httpRequest);
        request.setAttribute("user", user);
		chain.doFilter(request, response);
	}

	/**
	 * @param fConfig
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// Metodo init
	}

	@Override
	public void destroy() {
		// Metodo destroy
	}

}
