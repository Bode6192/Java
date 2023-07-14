package com.springbot.blog.controller;

import com.springbot.blog.payload.JwtAuthResponse;
import com.springbot.blog.payload.LoginDto;
import com.springbot.blog.payload.SignUpDto;
import com.springbot.blog.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Tag(
        name = "CRUD REST APIs for Authentication Resource"
)
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = {"/login", "/sign-in"})
    public ResponseEntity<JwtAuthResponse> Login(@RequestBody LoginDto loginDto) {

        String token = authService.login(loginDto);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping(value = {"sign-up", "register"})
    public ResponseEntity<String> signUp(@RequestBody SignUpDto signUpDto){

        String response = authService.signUp(signUpDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
