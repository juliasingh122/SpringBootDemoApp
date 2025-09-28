package com.example.demo.dao;

import java.sql.ResultSet;

import com.example.demo.domain.User;

public class UserDao {

    public ResultSet getList() {
        String sql = "SELECT * FROM users";
        return MyJDBC.executeQuery(sql);
    }

    public ResultSet getUser(String userId) {
        String sql = "SELECT * FROM users WHERE userId='" + userId + "'";
        return MyJDBC.executeQuery(sql);
    }

    public void updateUser(User user) {
        // First, update the user's basic info
        String sql = "UPDATE users SET userName='" + user.getUserName() + "' WHERE userId='" + user.getUserId() + "'";
        MyJDBC.executeUpdate(sql);

        // Then, update the user's roles (many-to-many)
        // Clear existing roles
        String deleteSql = "DELETE FROM user_roles WHERE user_id='" + user.getUserId() + "'";
        MyJDBC.executeUpdate(deleteSql);

        // Insert new roles
        if (user.getRoles() != null) {
            for (var role : user.getRoles()) {
                String insertSql = "INSERT INTO user_roles (user_id, role_id) VALUES ('" + user.getUserId() + "', '" + role.getRoleId() + "')";
                MyJDBC.executeUpdate(insertSql);
            }
        }
    }
}
