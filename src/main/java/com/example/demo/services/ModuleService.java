package com.example.demo.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.ModuleDao;
import com.example.demo.dao.RoleDao;
import com.example.demo.domain.Module;


@Service
public class ModuleService {
	
	public List<Module> getList(){
		List<Module> modules = new ArrayList<Module>();
		ModuleDao pd = new ModuleDao();
		RoleService sRole = new RoleService();
		ResultSet rs = pd.getList();
		try {
			while(rs.next()) {
				Module p = new Module(rs.getString(1), rs.getString(2));
				modules.add(p);
				p.setRoles(sRole.getListByModuleId(p.getId()));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modules;
		
	}

}
