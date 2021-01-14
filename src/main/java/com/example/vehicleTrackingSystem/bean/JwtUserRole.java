package com.example.vehicleTrackingSystem.bean;

import java.util.Set;


/**
 * Created by aishwarya on 1/13/21.
 */

/**
 * This class represents a logged JWT user's credentials.
 *
 */
public class JwtUserRole {

	private String username;
	private Set<String> roles;

	public JwtUserRole() {}

	public JwtUserRole(String username, Set<String> roles) {
		super();
		this.username = username;
		this.roles = roles;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
}
