package com.badminton.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.badminton.domain.Result;
import com.badminton.domain.User;
import com.badminton.repository.UserRepository;
import com.badminton.util.ResultUtil;

@RestController
public class UserController {
	
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	/*
	 * 查询所有用户
	 */
	@GetMapping(value = "/users")
	public List<User> getUserList(){
		return userRepository.findAll();
	}
	
	/*
	 * 添加一个用户
	 */
	@PostMapping(value = "/users")
	public User addUser(@RequestParam("username") String sName,
										@RequestParam("age") Integer age) {
		User user = new User();
		user.setUsername(sName);
		user.setAge(age);
		
		return userRepository.save(user);
	}
	
	@PostMapping(value = "/users2")
	public Result<User> addUser2(@Valid User user,BindingResult bindingResult) {
		if(bindingResult.hasErrors())
		{
			return ResultUtil.faild(1, bindingResult.getFieldError().getDefaultMessage());
			
		}

		return ResultUtil.success(userRepository.save(user));
	}
	
	/*
	 * 查询用户
	 */
	@GetMapping(value = "/user/{id}")
	public User userFindOne(@PathVariable("id") Integer id) {
		return userRepository.findById(id).orElse(null);
	}
	
	/*
	 * 更新
	 */
	@PutMapping(value = "/user/{id}")
	public User userUpdate(@PathVariable("id") Integer id,
										  @RequestParam("username") String sName,
										  @RequestParam("age") Integer age) {
		User user = new User();
		user.setId(id);
		user.setAge(age);
		user.setUsername(sName);
		
		return userRepository.save(user);
	}

	/*
	 * 删除
	 */
	@DeleteMapping(value = "/user/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		logger.info(id.toString());
		userRepository.deleteById(id);
	}
	
	@GetMapping(value = "users/getAge/{id}")
	public void getAge(@PathVariable("id") Integer id) {
		
	}
}
