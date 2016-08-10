package com.bullying.ut;

import static com.bullying.util.Constants.CONSTANTS;
import static com.bullying.util.Constants.ERROR_PRUEBA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ResourceBundle;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.bullying.dto.UserDto;
import com.bullying.exception.ValidatorException;
import com.bullying.model.TypeProfile;
import com.bullying.model.User;


/**
 * 
 * @author juan.botero
 *
 */
public class UserTest 
{
	private static final String BOTEROJUANPA_GMAIL_COM = "boterojuanpa@gmail.com";
	private static final String PRUEBA_GMAIL_COM = "prueba@gmail.com";
	private static final String PRUEBA = "Prueba";
	private static final Logger LOGGER = LogManager.getLogger(UserTest.class);
	
	/**
	 * @category test
	 */
	@Test
	public void testCreateUserIdNull()
	{
		try {
			new User(null,PRUEBA, PRUEBA_GMAIL_COM,new TypeProfile());
			fail();
		} catch (ValidatorException ve) 
		{
			LOGGER.error(ResourceBundle.getBundle(CONSTANTS).getString(ERROR_PRUEBA), ve);
			assertEquals(User.ID_USER_IS_NOT_NULL, ve.getMessage());
		}
	}
	
	/**
	 * @category test
	 */
	@Test
	public void testCreateUserNameNull()
	{
		try {
			new User(123L,null, PRUEBA_GMAIL_COM,new TypeProfile());
			fail();
		} catch (ValidatorException ve) 
		{
			LOGGER.error(ResourceBundle.getBundle(CONSTANTS).getString(ERROR_PRUEBA), ve);
			assertEquals(User.NAME_IS_NOT_NULL, ve.getMessage());
		}
	}
	
	/**
	 * @category test
	 */
	@Test
	public void testCreateEmailNull()
	{
		try {
			new User(123L,PRUEBA, null,new TypeProfile());
			fail();
		} catch (ValidatorException ve) 
		{
			LOGGER.error(ResourceBundle.getBundle(CONSTANTS).getString(ERROR_PRUEBA), ve);
			assertEquals(User.EMAIL_IS_NOT_NULL, ve.getMessage());
		}
	}
	
	/**
	 * @category test
	 */
	@Test
	public void testCreateProfileNull()
	{
		try {
			new User(123L,PRUEBA, BOTEROJUANPA_GMAIL_COM,null);
			fail();
		} catch (ValidatorException ve) 
		{
			LOGGER.error(ResourceBundle.getBundle(CONSTANTS).getString(ERROR_PRUEBA), ve);
			assertEquals(User.PROFILE_IS_NOT_NULL, ve.getMessage());
		}
	}
	
	@Test
	public void testCreateUserFromUserDto()
	{
		UserDto userDto = new UserDto();
		userDto.setEmail("prueba@gmail.com");
		userDto.setId(1L);
		userDto.setName("usuario pruebas");
		User user = User.createUserFromUserDto(userDto);
		assertEquals(userDto.getEmail(), user.getEmail());
		assertEquals(userDto.getName(), user.getName());
		assertTrue(userDto.getId() == user.getIdUserSocial());
		
	}
}
