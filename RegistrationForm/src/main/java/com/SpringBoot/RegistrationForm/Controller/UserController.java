package com.SpringBoot.RegistrationForm.Controller;

import com.SpringBoot.RegistrationForm.Entity.User;
import com.SpringBoot.RegistrationForm.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String register(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") User user) {

        System.out.println(user);
        userService.registerUser(user);
        return "home";
    }
}