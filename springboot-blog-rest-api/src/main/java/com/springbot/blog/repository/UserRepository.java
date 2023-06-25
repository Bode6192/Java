package com.springbot.blog.repository;

import com.springbot.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String userName, String email);

    Optional<User> findBuUsername(String username);

    Boolean existsByUsername(String userName);

    Boolean existsByEmail(String email);
}
