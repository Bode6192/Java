package com.springbot.blog.controller;

import com.springbot.blog.payload.LoginDto;
import com.springbot.blog.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.BasicValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = {"/login", "/sign-in"})
    public ResponseEntity<String> Login(@RequestBody LoginDto loginDto) {

        String response = authService.login(loginDto);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<String> signUp(){
        
    }
}
