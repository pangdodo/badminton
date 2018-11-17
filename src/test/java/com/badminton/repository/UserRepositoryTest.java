package com.badminton.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.badminton.domain.User;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void findByIdTest() {
		User user = userRepository.findById(7).orElse(null);
		Assert.assertNotNull(user);
	}
	
	@Test
	@Transactional
	public void saveTest() {
		User user = new User();
		user.setAge(22);
		user.setUsername("测试保存1");
		User newuser = userRepository.save(user);
		Assert.assertEquals(user, newuser);
	}
	
	@Test
	public void findByAgeInTest(){
		List<Integer> list = new ArrayList<>();
		// Collections.addAll(list, 1, 2, 3);
		Integer[] arr = {15, 28};
		Collections.addAll(list, arr);

		List<User> uList = userRepository.findByAgeIn(list);
		Assert.assertNotNull(uList);
	}
}
