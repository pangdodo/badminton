package com.badminton.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.badminton.domain.User;
import com.badminton.repository.UserRepository;

public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void insertTow() {
		User userA = new User();
		userA.setAge(15);
		userA.setUsername("A");
		userRepository.save(userA);
		
		User userB = new User();
		userB.setAge(22);
		userB.setUsername("B");
		userRepository.save(userB);
	}
	
	public void getAge(Integer id) {
//		User user = userRepository.findById(id);
//		Integer age = user.getAge();
//		if(age<10) {
//			
//		}else if (age >10 && age<16){
//			
//		}
	}
	
}
