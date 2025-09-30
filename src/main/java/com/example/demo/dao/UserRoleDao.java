package com.example.demo.dao;

import java.util.List;

import com.example.demo.domain.WUser;

public class UserRoleDao {
	public void updateUserRole(WUser wu) {
		
        String sql = "DELETE FROM userrole WHERE userId=" + wu.getUser().getUserId();
        MyJDBC.executeUpdate(sql);
        
        List<String> selectedRoles = wu.getSelectedRoles();


		
		for (int i=0;i<selectedRoles.size(); i++) {
			
			sql = "INSERT INTO userrole (userId, roleId) VALUES ("+ wu.getUser().getUserId() + ", " + selectedRoles.get(i) + ");";
			MyJDBC.executeUpdate(sql);
	       
		}
    }

}
