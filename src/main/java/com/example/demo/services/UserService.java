package com.example.demo.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.RoleDao;
import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserRoleDao;
import com.example.demo.domain.User;
import com.example.demo.domain.WUser;

@Service
public class UserService {

    public List<User> getList() {
        List<User> users = new ArrayList<>();

        UserDao ud = new UserDao();

        ResultSet rs = ud.getList();

        try {
            while (rs.next()) {
                User u = new User(rs.getString(1), rs.getString(2));
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
                        rs.getString(2)  // userName
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
