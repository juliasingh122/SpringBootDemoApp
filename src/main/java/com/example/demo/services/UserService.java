package com.example.demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.LoginUser;
import com.example.demo.domain.User;

@Service
public class UserService implements UserDetailsService{
	
	@Lazy
	@Autowired
	PasswordEncoder passwordEncoder;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
			return new LoginUser(getUserByName(username));
	}
	
	
	
	
	
	RoleService rs = new RoleService();
	
	List<User> users = new ArrayList<User>();
		
	
	public List<User> getUsers() {
		createUsers();
		return users;
		
	}

	public void createUsers() {
		users.add(new User("1","Puru", passwordEncoder.encode("Puru")));
		users.add(new User("1","Olga", passwordEncoder.encode("Olga")));
	}

    public User getUserById(String id) {
    	createUsers();
		User user;
		
		if(id.equals("1")) {
			
			user =getUsers().stream().filter(u-> u.getId().equals(id)).toList().get(0);
			user.getRoles().add(rs.getRoleById("1"));
			user.getRoles().add(rs.getRoleById("3"));
		}
		else {
			user =getUsers().stream().filter(u-> u.getId().equals(id)).toList().get(0);
			user.getRoles().add(rs.getRoleById("2"));
			user.getRoles().add(rs.getRoleById("3"));
			user.getRoles().add(rs.getRoleById("4"));
			
		}
		
		return user;

		
	}
    
    public User getUserByName(String name) {
		
		if(name.equals("Puru")) {
			
			return getUserById("1");
		}
		else {
			return getUserById("2");
			
		}
		
	}

}
