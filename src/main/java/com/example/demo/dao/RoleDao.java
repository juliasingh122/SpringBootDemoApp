package com.example.demo.dao;

import java.sql.ResultSet;

import com.example.demo.domain.Role;

public class RoleDao {

    public ResultSet getList() {
        String sql = "SELECT * FROM roles";
        return MyJDBC.executeQuery(sql);
    }

    public ResultSet getRole(String roleId) {
        String sql = "SELECT * FROM roles WHERE roleId='" + roleId + "'";
        return MyJDBC.executeQuery(sql);
    }

    public void updateRole(Role role) {
        String sql = "UPDATE roles SET roleName='" + role.getRoleName() +
                     "' WHERE roleId='" + role.getRoleId() + "'";
        MyJDBC.executeUpdate(sql);
    }
}
