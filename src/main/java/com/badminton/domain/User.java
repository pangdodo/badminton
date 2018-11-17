package com.badminton.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Entity
@DynamicUpdate
@Data
public class User {

		@Id
	    @GeneratedValue
	    private Integer id;

	    @Column
	    private String username;

	    @Column
	    @Min(value = 22, message = "未成年禁止入内")
	    private int age;

	    public User() {
	    	
	    }
	    
		public User(String username, @Min(value = 22, message = "未成年禁止入内") int age) {
			super();
			this.username = username;
			this.age = age;
		}
	
	    
}

