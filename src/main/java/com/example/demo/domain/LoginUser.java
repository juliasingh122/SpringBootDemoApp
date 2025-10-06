package com.example.demo.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;


public class LoginUser implements UserDetails {
	
	/**
	 * 
	 */

	
	private static final long serialVersionUID = 1L;
	private User user;

	public LoginUser(User user) {
		this.user=user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		//List<String> roles = new ArrayList<String>();
		
		return user.getRoles().stream().map(r-> new SimpleGrantedAuthority(r.name)).collect(Collectors.toList());
		
		/*return Arrays.stream(roles.)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());*/
	}

	@Override
	public String getPassword() {
	
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getName();
	}

}
