package com.example.demo.dto;

import lombok.Data;

@Data
public class UserDto4 {
	private Long id;
	private String email;
	private String password;

	public UserDto4(Long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}

}