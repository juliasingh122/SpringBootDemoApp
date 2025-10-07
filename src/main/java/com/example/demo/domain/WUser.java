package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class WUser {
	User user = new User();
	List<String> selectedRoles = new ArrayList<String>();
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<String> getSelectedRoles() {
		return selectedRoles;
	}
	public void setSelectedRoles(List<String> selectedRoles) {
		this.selectedRoles = selectedRoles;
	}
}
