package com.dailycodebuffer.springsecuritytutorial.repository;

import com.dailycodebuffer.springsecuritytutorial.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
