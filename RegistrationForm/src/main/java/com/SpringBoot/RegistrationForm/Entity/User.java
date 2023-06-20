package com.SpringBoot.RegistrationForm.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_register")
public class User {

    @Id
    private String userName;

    private String name;
    private String email;
    private String phone;
    private String password;
    private String confirmPassword;
    private String gender;
}