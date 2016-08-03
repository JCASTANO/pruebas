package com.bullying.test.integration;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bullying.Application;
import com.bullying.model.User;
import com.bullying.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional
public class UserTest 
{
	@Autowired
	UserRepository userRepository;

	@Test
	public void testInsertUser()
	{
		User user = new User(123L,"Prueba", "prueba@gmail.com", null);
		user.setEmail("prueba@gmail.com");
		user.setId(123L);
		user.setName("Prueba");
		userRepository.insertar(user);		
		User userBd = (User) userRepository.buscarPorId(User.class, 123L);
		assertEquals(user.getEmail(), userBd.getEmail());
		assertEquals(user.getEmail(), userBd.getEmail());
		assertEquals(user.getId(), userBd.getId());
	}
}
