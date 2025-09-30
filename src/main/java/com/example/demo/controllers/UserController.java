package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.domain.WUser;
import com.example.demo.services.RoleService;
import com.example.demo.services.UserService;

@Controller
@RequestMapping("/Users")
public class UserController {

    @Autowired
    UserService us;

    @GetMapping("")
    public String users(Model model) {
        model.addAttribute("users", us.getList());
        return "users";
    }

    @GetMapping("/{id}")
    public String userdetails(@PathVariable("id") String id, Model model) {
    	WUser wu = new WUser();
    	wu.setUser(us.getUserById(id));
    	RoleService rs = new RoleService();
    	List<Role> selectedRoles = rs.getListbyUserId(id);
    	
    	for (Role r : selectedRoles) {
			wu.getSelectedRoles().add(r.getRoleId());
		}
    	
    	
        model.addAttribute("wuser", wu);
        
        model.addAttribute("roles", rs.getList());
        
       
        

        return "userdetails";
    }
    

    @PostMapping("/{id}")
    public String postUserdetails(@PathVariable("id") String id, @ModelAttribute("wuser") WUser wu, Model model) {
    	us.updateUserRole(wu);
        return "userdetails";
    }
}
