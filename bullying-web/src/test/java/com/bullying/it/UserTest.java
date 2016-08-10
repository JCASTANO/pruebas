package com.bullying.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bullying.Application;
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
@SpringApplicationConfiguration(classes = Application.class)
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
		User userBd = (User) userRepository.buscarPorId(User.class, 123L);
		assertEquals(user.getEmail(), userBd.getEmail());
		assertEquals(user.getEmail(), userBd.getEmail());
		assertEquals(user.getId(), userBd.getId());
	}
	
	/**
	 * @category test
	 */
	@Test
	public void testGetUserSecurityUnknown()
	{
		User userFacebook = new User();
		userFacebook.setId(10000L);
		userFacebook.setEmail("prueba@gmail.com");
		userFacebook.setName("Usuario de prueba");
		User userSecurity = userService.getUserSecurity(userFacebook);
		User userInRepository =  (User) userRepository.buscarPorId(User.class, 10000L);		
		assertTrue(userInRepository != null);
		assertEquals(userFacebook.getEmail(), userInRepository.getEmail());
		assertEquals(userFacebook.getName(), userInRepository.getName());
		assertTrue(userInRepository.getProfile().getIdProfile() == TypeProfile.ID_PROFILE_GENERAL);
		assertTrue(userSecurity != null);		
	}
}
