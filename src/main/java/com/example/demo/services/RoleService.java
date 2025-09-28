package com.example.demo.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.RoleDao;
import com.example.demo.domain.Role;

@Service
public class RoleService {

    public List<Role> getList() {
        List<Role> roles = new ArrayList<>();
        RoleDao rd = new RoleDao();
        ResultSet rs = rd.getList();
        try {
            while (rs.next()) {
                Role r = new Role(
                        rs.getString(1), // roleId
                        rs.getString(2)  // roleName
                );
                roles.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    public Role getRoleById(String id) {
        RoleDao rd = new RoleDao();
        ResultSet rs = rd.getRole(id);

        Role r = null;
        try {
            if (rs.next()) {
                r = new Role(
                        rs.getString(1), // roleId
                        rs.getString(2)  // roleName
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    public void updateRole(Role role) {
        RoleDao rd = new RoleDao();
        rd.updateRole(role);
    }
}
