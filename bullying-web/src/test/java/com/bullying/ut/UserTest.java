package com.bullying.ut;

import static com.bullying.util.Constants.CONSTANTS;
import static com.bullying.util.Constants.ERROR_PRUEBA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.ResourceBundle;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import com.bullying.exception.ValidatorException;
import com.bullying.model.TypeProfile;
import com.bullying.model.User;

public class UserTest 
{
	private static final Logger LOGGER = LogManager.getLogger(UserTest.class);
	
	@Test
	public void testCreateUserIdNull()
	{
		try {
			new User(null,"Prueba", "prueba@gmail.com",new TypeProfile());
			fail();
		} catch (ValidatorException ve) 
		{
			LOGGER.error(ResourceBundle.getBundle(CONSTANTS).getString(ERROR_PRUEBA), ve);
			assertEquals(User.ID_USER_IS_NOT_NULL, ve.getMessage());
		}
	}
	
	@Test
	public void testCreateUserNameNull()
	{
		try {
			new User(123L,null, "prueba@gmail.com",new TypeProfile());
			fail();
		} catch (ValidatorException ve) 
		{
			LOGGER.error(ResourceBundle.getBundle(CONSTANTS).getString(ERROR_PRUEBA), ve);
			assertEquals(User.NAME_IS_NOT_NULL, ve.getMessage());
		}
	}
	
	@Test
	public void testCreateEmailNull()
	{
		try {
			new User(123L,"Prueba", null,new TypeProfile());
			fail();
		} catch (ValidatorException ve) 
		{
			LOGGER.error(ResourceBundle.getBundle(CONSTANTS).getString(ERROR_PRUEBA), ve);
			assertEquals(User.EMAIL_IS_NOT_NULL, ve.getMessage());
		}
	}
	
	@Test
	public void testCreateProfileNull()
	{
		try {
			new User(123L,"Prueba", "boterojuanpa@gmail.com",null);
			fail();
		} catch (ValidatorException ve) 
		{
			LOGGER.error(ResourceBundle.getBundle(CONSTANTS).getString(ERROR_PRUEBA), ve);
			assertEquals(User.PROFILE_IS_NOT_NULL, ve.getMessage());
		}
	}
}
