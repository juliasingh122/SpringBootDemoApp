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

	private RoleDao rd = new RoleDao();
	private List<Role> changeToList(ResultSet rs ){
		  List<Role> roles = new ArrayList<>();
		  try {
	            while (rs.next()) {
	                Role r = new Role(
	                        rs.getString(1), // roleId
	                        rs.getString(2)  // roleName
	                );
	                roles.add(r);
	            }
	            rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		  
		  return roles;
	}
	
    public List<Role> getList() {
      
       
        ResultSet rs = rd.getList();
        return changeToList(rs);
    }

    public List<Role> getListByModuleId(String moduleId) {
        ResultSet rs = rd.getList();
        return changeToList(rs);
    }

    
    public Role getRoleById(String id) {
        ResultSet rs = rd.getRole(id);

        return changeToList(rs).get(0);
    }
    public List<Role> getListbyUserId(String id) {
  
        ResultSet rs = rd.getListByUserId(id);
        return changeToList(rs);
    }
    
    public List<Role> getListbyModuleId(String id) {
    	  
        ResultSet rs = rd.getListByModuleId(id);
        return changeToList(rs);
    }

    public void updateRole(Role role) {
        RoleDao rd = new RoleDao();
        rd.updateRole(role);
    }
}
