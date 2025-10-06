package com.example.demo.domain;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	String id;
	String name;
	String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	Set<Role> roles = new HashSet<Role>();
	
	public User(String id, String name, String password) {
		this.id = id;
		this.name= name;
		this.password= password;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


}
