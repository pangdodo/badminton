package com.badminton.controller;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.badminton.domain.User;
import com.badminton.repository.UserRepository;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void test() {
		//fail("Not yet implemented");
	}

	@Test
	public void findByIdTest() {
		User user = userRepository.findById(7).orElse(null);
		Assert.assertNotNull(user);
	}
}
