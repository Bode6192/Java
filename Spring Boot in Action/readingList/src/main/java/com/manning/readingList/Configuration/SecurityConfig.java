package com.manning.readingList.Configuration;

import com.manning.readingList.Entity.Reader;
import com.manning.readingList.Repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private ReaderRepository readerRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests((authz) -> authz
                        .requestMatchers("/").access("hasRole('READER')")
                        .requestMatchers("/**").permitAll()
                )
                .formLogin((formLogin) -> formLogin
                        .loginPage("/login")
                        .failureUrl("/login?error=true")
                );

        http.csrf().disable(); // disable CSRF protection for simplicity

        http.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Reader reader = readerRepository.findByUsername(username);
                if (reader == null) {
                    throw new UsernameNotFoundException("User not found: " + username);
                }
                return new User(reader.getUsername(), reader.getPassword(), AuthorityUtils.createAuthorityList("ROLE_READER"));
            }

        });

        return http.build();
    }
}

