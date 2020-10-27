package com.airport.model;

import javax.validation.constraints.NotNull;

public class Login {
		
	@NotNull(message="Enter the Id")
	private Integer id;
	@NotNull(message="Enter the password")
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Login(){}
}
