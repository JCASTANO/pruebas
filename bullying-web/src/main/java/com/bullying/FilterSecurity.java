package com.bullying;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.client.RestTemplate;

import com.bullying.model.User;

/**
 * Servlet Filter implementation class FilterSecurity
 */
public class FilterSecurity implements Filter {



	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Cookie cookie = getCookie(httpRequest);
		
		RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject("https://graph.facebook.com/me?access_token={token}&fields=email,name", User.class,cookie.getValue() );
        if(user != null)
        {
        	System.out.println(user.getEmail());
        }
        
		chain.doFilter(request, response);
	}

	private Cookie getCookie(HttpServletRequest httpRequest) {
		Cookie[] cookies = httpRequest.getCookies();
		Optional<Cookie> optional =Arrays.stream(cookies).filter(c -> "Facebook-Token".equals(c.getName())).findFirst();
		Cookie cookie = null;
		if(optional.isPresent()) {
		    cookie = optional.get();
		}
		return cookie;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void destroy() {
		
	}

}
