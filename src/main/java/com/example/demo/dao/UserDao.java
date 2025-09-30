package com.example.demo.dao;

import java.sql.ResultSet;

import com.example.demo.domain.User;

public class UserDao {

    public ResultSet getList() {
        String sql = "SELECT * FROM users";
        return MyJDBC.executeQuery(sql);
    }

    public ResultSet getUser(String userId) {
    	System.out.println(13);
        String sql = "SELECT * FROM users WHERE userId='" + userId + "'";
    	System.out.println(14);

        return MyJDBC.executeQuery(sql);
    }

    public void updateUser(User user) {

        String sql = "UPDATE users SET userName='" + user.getUserName() + "' WHERE userId='" + user.getUserId() + "'";
        MyJDBC.executeUpdate(sql);

        String deleteSql = "DELETE FROM user_roles WHERE user_id='" + user.getUserId() + "'";
        MyJDBC.executeUpdate(deleteSql);

        if (user.getRoles() != null) {
            for (var role : user.getRoles()) {
                String insertSql = "INSERT INTO user_roles (user_id, role_id) VALUES ('" + user.getUserId() + "', '" + role.getRoleId() + "')";
                MyJDBC.executeUpdate(insertSql);
            }
        }
    }
}
