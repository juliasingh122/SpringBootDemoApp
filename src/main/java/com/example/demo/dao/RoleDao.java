package com.example.demo.dao;

import java.sql.ResultSet;
import java.util.List;

import com.example.demo.domain.Role;
import com.example.demo.domain.WUser;

public class RoleDao {

    public ResultSet getList() {
        String sql = "SELECT * FROM roles";
        return MyJDBC.executeQuery(sql);
    }
    public ResultSet getListByUserId(String userId) {
        String sql = "SELECT * " +
                     "FROM roles r " +
                     "JOIN userrole ur ON r.roleId = ur.roleId " +
                     "WHERE ur.userId = '" + userId + "'";
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
