package com.springbot.blog.security;

import com.springbot.blog.entity.User;
import com.springbot.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    public final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException {

        User user = userRepository.findByUserNameOrEmail(userNameOrEmail, userNameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with UserName or Email: " + userNameOrEmail));

        return null;
    }
}
