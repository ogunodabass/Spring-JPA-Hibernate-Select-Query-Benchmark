package com.example.demo.dto;

import com.example.demo.entity.User;

import lombok.Data;

@Data
public class UserDto1 {
	private Long id;
	private String email;
	private String password;
	private AdressDTO1 adressDTO;

	public UserDto1(Long id, String email, String password, Long adressId, int adressNo, String adressHouse) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.adressDTO = new AdressDTO1(adressId, adressNo, adressHouse);
	}

	public static UserDto1 entityToDto(User user) {
		UserDto1 userDto1 = new UserDto1(user.getId(), user.getEmail(), user.getPassword(), user.getAdress().getId(),
				user.getAdress().getNo(), user.getAdress().getHouse());
		return userDto1;
	}
}
