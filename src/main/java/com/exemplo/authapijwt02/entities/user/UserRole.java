package com.exemplo.authapijwt02.entities.user;

public enum UserRole {

	ADMIN("admin"),
	USER("user");
	
	private String role;

	UserRole(String role) {
		// TODO Auto-generated constructor stub
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
	
}
