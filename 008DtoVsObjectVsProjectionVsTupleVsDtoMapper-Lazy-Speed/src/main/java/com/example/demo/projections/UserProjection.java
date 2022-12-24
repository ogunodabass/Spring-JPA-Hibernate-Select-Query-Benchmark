package com.example.demo.projections;

public interface UserProjection {

	public Long getId();
	
	public String getEmail();
	
	public String getPassword();
	
	public AdressProjection getAdress();
	
}
