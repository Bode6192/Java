package com.dailycodebuffer.springsecuritytutorial.service;

import com.dailycodebuffer.springsecuritytutorial.entity.User;
import com.dailycodebuffer.springsecuritytutorial.model.UserModel;

public interface UserService {

    User registerUser(UserModel userModel);
}
