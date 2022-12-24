package com.example.demo.dto;

import lombok.Data;

@Data
public class UserDto5 {
	private Long id;
	private String email;

	public UserDto5(Long id, String email) {
		this.id = id;
		this.email = email;
	}

}