package com.bullying.ut;

import static org.junit.Assert.*;
import org.junit.Test;

import com.bullying.dto.UserDto;
import com.bullying.exception.ValidatorException;
import com.bullying.model.TypeProfile;
import com.bullying.model.User;

public class UserTest 
{
	@Test
	public void testCreateUserIdNull()
	{
		try {
			new User(null,"Prueba", "prueba@gmail.com",new TypeProfile());
			fail();
		} catch (ValidatorException ve) 
		{
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
