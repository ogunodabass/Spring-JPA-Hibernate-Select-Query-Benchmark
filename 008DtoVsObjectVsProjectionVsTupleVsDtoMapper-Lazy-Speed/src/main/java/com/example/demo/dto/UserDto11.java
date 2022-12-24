package com.example.demo.dto;

import lombok.Data;

@Data
public class UserDto11 {
	private Long id;
	private String email;
	private String password;
	private AdressDTO1 adressDTO;

	
	public UserDto11(Long id, String email, String password, Long adressId, int adressNo, String adressHouse) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.adressDTO = new AdressDTO1(adressId, adressNo, adressHouse);
	}

	public static UserDto11 objectToDTO(Object o[]) {
		UserDto11 userDto1 = new UserDto11((Long) o[0],(String) o[1],(String) o[2],(Long)o[3],(Integer) o[4],(String) o[5]);
		return userDto1;
	}


}
