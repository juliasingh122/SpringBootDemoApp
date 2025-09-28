package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
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
        return "users"; // users.html
    }

    @GetMapping("/{id}")
    public String userdetails(@PathVariable("id") String id, Model model) {
        model.addAttribute("user", us.getUserById(id));
        RoleService rs = new RoleService();
        model.addAttribute("allRoles", rs.getList());
        return "userdetails"; // userdetails.html
    }

    @PostMapping("/{id}")
    public String postUserdetails(@PathVariable("id") String id, @ModelAttribute("user") User user, Model model) {
        us.updateUser(user);
        return "userdetails"; // stays on details page
    }
}
