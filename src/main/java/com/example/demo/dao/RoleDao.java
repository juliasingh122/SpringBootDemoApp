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
        String sql = "SELECT r.* " +
                     "FROM roles r " +
                     "JOIN userrole ur ON r.Id = ur.roleId " +
                     "WHERE ur.userId = '" + userId + "'";
        return MyJDBC.executeQuery(sql);
    }

    public ResultSet getListByModuleId(String moduleId) {
        String sql = "SELECT r.* " +
                     "FROM roles r " +
                     "inner JOIN moduleRole ur ON r.Id = ur.roleId " +
                     "WHERE ur.moduleId = '" + moduleId + "'";
        return MyJDBC.executeQuery(sql);
    }

    public ResultSet getRole(String Id) {
        String sql = "SELECT * FROM roles WHERE Id='" + Id + "'";
        return MyJDBC.executeQuery(sql);
    }

    public void updateRole(Role role) {
        String sql = "UPDATE roles SET roleName='" + role.getName() +
                     "' WHERE roleId='" + role.getId() + "'";
        MyJDBC.executeUpdate(sql);
    }
}
