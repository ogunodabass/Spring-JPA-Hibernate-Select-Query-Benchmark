package com.example.demo.dto;

import lombok.Data;

@Data
public class UserDto3 {
	private Long id;
	private String email;
	private String password;
	private AdressDTO3 adressDTO;

	public UserDto3(Long id, String email, String password, Long adressId) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.adressDTO = new AdressDTO3(adressId);
	}

}