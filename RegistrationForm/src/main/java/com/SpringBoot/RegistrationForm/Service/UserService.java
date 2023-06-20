package com.SpringBoot.RegistrationForm.Service;

import com.SpringBoot.RegistrationForm.Entity.User;
import com.SpringBoot.RegistrationForm.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void registerUser(User user){

        userRepository.save(user);
    }
}
