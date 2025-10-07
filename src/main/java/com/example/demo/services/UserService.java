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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserRoleDao;
import com.example.demo.domain.WUser;


@Service
public class UserService implements UserDetailsService{
	
	@Lazy
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	RoleService rs;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
			return new LoginUser(getUserByName(username));
	}
	
		
    
    public User getUserByName(String name) {
    	UserDao ud = new UserDao();
        ResultSet rs = ud.getUser(name);
        try {
			rs.next();
			User u = new User(rs.getString(1), rs.getString(2), rs.getString(3));
			rs.close();
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
        
    }	

		
    public List<User> getList() {
        List<User> users = new ArrayList<>();

        UserDao ud = new UserDao();

        ResultSet rs = ud.getList();

        try {
            while (rs.next()) {
                User u = new User(rs.getString(1), rs.getString(2), rs.getString(3));
                users.add(u);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getUserById(String id) {
        UserDao ud = new UserDao();
        ResultSet rs = ud.getUser(id);

        User u = null;
        try {
            if (rs.next()) {
                u = new User(
                        rs.getString(1), // userId
                        rs.getString(2),  // userName
                        rs.getString(3)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public void updateUser(User user) {
        UserDao ud = new UserDao();
        ud.updateUser(user);
    }
    
    public void updateUserRole(WUser wu) {
    	UserRoleDao urd = new UserRoleDao();
    	urd.updateUserRole(wu);
    }
}
