package com.badminton.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.badminton.domain.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	List<User> findByAgeIn(List<Integer> ageList);
}
