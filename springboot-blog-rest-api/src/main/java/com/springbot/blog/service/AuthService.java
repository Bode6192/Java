package com.springbot.blog.service;

import com.springbot.blog.entity.Role;
import com.springbot.blog.entity.User;
import com.springbot.blog.exception.BlogAPIException;
import com.springbot.blog.payload.LoginDto;
import com.springbot.blog.payload.SignUpDto;
import com.springbot.blog.repository.RoleRepository;
import com.springbot.blog.repository.UserRepository;
import com.springbot.blog.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private  final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUserNameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

    public String signUp(SignUpDto signUpDto){

        // Check for already existing UserName
        if(userRepository.existsByUserName(signUpDto.getUserName())) {

            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Username already exists!!!");
        }

        // Check for Already existing Email
        if (userRepository.existsByEmail(signUpDto.getEmail())){

            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Email already exists!!!");
        }

        User user = new User();
        user.setEmail(signUpDto.getEmail());
        user.setUserName(signUpDto.getUserName());
        user.setName(signUpDto.getName());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER").get();

        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);

        return "User Registered Successfully!!!";
    }
}
