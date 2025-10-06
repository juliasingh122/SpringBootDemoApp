package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;

@Service
public class RoleService {
	public List<Role> getRoles() {
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(new Role("1","Admin"));
		roles.add(new Role("2","Users"));
		roles.add(new Role("3","Operators"));
		roles.add(new Role("4","Externals"));
		return roles;
		
	}

    public Role getRoleById(String id) {
		
		List<Role> roles= getRoles();
		for (Role role : roles) {
			if(role.getId().equals(id)) {
				return role;
			}
			
		}
		
		return null;
	}

}
