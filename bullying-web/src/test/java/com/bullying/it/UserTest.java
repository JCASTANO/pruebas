package com.bullying.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bullying.ApplicationTest;
import com.bullying.dto.UserDto;
import com.bullying.model.TypeProfile;
import com.bullying.model.User;
import com.bullying.repository.UserRepository;
import com.bullying.service.UserService;

/**
 * 
 * @author juan.castano
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationTest.class)
@Transactional
public class UserTest 
{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;

	/**
	 * @category test
	 */
	@Test
	public void testInsertUser()
	{
		TypeProfile typeProfile = (TypeProfile) userRepository.buscarPorId(TypeProfile.class, TypeProfile.ID_PROFILE_GENERAL);
		User user = new User(123L,"Prueba", "prueba@gmail.com", typeProfile);
		userRepository.guardar(user);		
		User userBd = userRepository.getUserByIdUserSocial(123L);
		assertEquals(user.getEmail(), userBd.getEmail());
		assertEquals(user.getEmail(), userBd.getEmail());
		assertEquals(user.getIdUserSocial(), userBd.getIdUserSocial());
	}
	
	/**
	 * @category test
	 */
	@Test
	public void testGetUserSecurityUnknown()
	{
		UserDto userFacebook = new UserDto();
		userFacebook.setId(10000L);
		userFacebook.setEmail("prueba@gmail.com");
		userFacebook.setName("Usuario de prueba");
		UserDto userSecurity = userService.getUserSecurity(userFacebook);
		User userInRepository =   userRepository.getUserByIdUserSocial(10000L);		
		assertTrue(userInRepository != null);
		assertEquals(userFacebook.getEmail(), userInRepository.getEmail());
		assertEquals(userFacebook.getName(), userInRepository.getName());
		assertTrue(userSecurity != null);	
		assertTrue(userSecurity.getIdBullying() != null && userSecurity.getIdBullying() > 0);	
	}
	
	@Test
	public void testGetUserByIdUserSocial()
	{
		TypeProfile typeProfile = (TypeProfile) userRepository.buscarPorId(TypeProfile.class, TypeProfile.ID_PROFILE_GENERAL);
		User user = new User(123L,"Prueba", "prueba@gmail.com", typeProfile);
		userRepository.guardar(user);
		User userFound = userRepository.getUserByIdUserSocial(123L);
		assertEquals(user.getEmail(), userFound.getEmail());
		assertEquals(user.getName(), userFound.getName());
		assertEquals(user.getIdUserSocial(), userFound.getIdUserSocial());
	}
}
