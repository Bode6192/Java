package com.SpringBoot.RegistrationForm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String register() {

        return "register";
    }
}