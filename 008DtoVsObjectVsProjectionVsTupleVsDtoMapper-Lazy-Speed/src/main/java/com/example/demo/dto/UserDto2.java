package com.example.demo.dto;

import lombok.Data;

@Data
public class UserDto2 {
	private Long id;
	private String email;
	private String password;
	private AdressDTO2 adressDTO;

	public UserDto2(Long id, String email, String password, Long adressId, int adressNo) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.adressDTO = new AdressDTO2(adressId, adressNo);
	}

	public static UserDto2 objectToDTO(Object[] o) {
		UserDto2 userDto1 = new UserDto2((Long) o[0], (String) o[1], (String) o[2], (Long) o[3], (Integer) o[4]);
		return userDto1;
	}
}