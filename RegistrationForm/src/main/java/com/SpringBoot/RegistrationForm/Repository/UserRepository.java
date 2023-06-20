package com.SpringBoot.RegistrationForm.Repository;

import com.SpringBoot.RegistrationForm.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}