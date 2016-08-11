package com.bullying.ut;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.mockito.Mockito;

import com.bullying.dto.UserDto;
import com.bullying.security.LoginFacebook;
import com.bullying.service.UserService;

/**
 * 
 * @author juan.botero
 *
 */
public class SecurityTest 
{	
	@Test
	public void getCookieFacebookFoundTest()
	{
		HttpServletRequest httpRequest =  Mockito.mock(HttpServletRequest.class);
		Cookie[] cookies = new Cookie[1];
		cookies[0] = new Cookie(LoginFacebook.FACEBOOK_TOKEN, "123");
		Mockito.when(httpRequest.getCookies()).thenReturn(cookies);
		LoginFacebook loginFacebook = new LoginFacebook();
		Cookie cookieFound =  loginFacebook.getCookie(httpRequest);
		assertTrue(cookieFound != null);
		assertEquals("123", cookieFound.getValue());		
	}
	
	@Test
	public void getCookieFacebooknotFoundTest()
	{
		HttpServletRequest httpRequest =  Mockito.mock(HttpServletRequest.class);
		Cookie[] cookies = new Cookie[1];
		cookies[0] = new Cookie("prueba", "123");
		Mockito.when(httpRequest.getCookies()).thenReturn(cookies);
		LoginFacebook loginFacebook = new LoginFacebook();
		Cookie cookieFound =  loginFacebook.getCookie(httpRequest);
		assertTrue(cookieFound == null);
	}
	
	@Test
	public void getUserTest()
	{
		HttpServletRequest httpRequest =  Mockito.mock(HttpServletRequest.class);
		Cookie[] cookies = new Cookie[1];
		cookies[0] = new Cookie(LoginFacebook.FACEBOOK_TOKEN, "123");
		Mockito.when(httpRequest.getCookies()).thenReturn(cookies);
		UserDto user = new UserDto();
		user.setId(1L);
		UserService userService = Mockito.mock(UserService.class);
		Mockito.when(userService.getUserSecurity(user)).thenReturn(user);		
		LoginFacebook loginFacebook = new LoginFacebook(userService);
		LoginFacebook loginSpy = Mockito.spy(loginFacebook);		
		Mockito.doReturn(user).when(loginSpy).getUserFromFacebook(cookies[0]);
		UserDto userFound = loginSpy.getUser(httpRequest);	
		assertTrue(userFound != null);
		assertTrue(1L == userFound.getId());
	}
	
	@Test
	public void getUserNoCookieTest()
	{
		HttpServletRequest httpRequest =  Mockito.mock(HttpServletRequest.class);
		Cookie[] cookies = new Cookie[1];
		cookies[0] = new Cookie("123", "123");
		Mockito.when(httpRequest.getCookies()).thenReturn(cookies);
		UserDto user = new UserDto();
		user.setId(1L);
		LoginFacebook loginFacebook = new LoginFacebook();
		try 
		{
			loginFacebook.getUser(httpRequest);
			fail();
		} 
		catch (WebApplicationException wae) 
		{
			assertTrue(wae.getResponse().getStatus() == Response.Status.FORBIDDEN.getStatusCode());
		}
	}
}
