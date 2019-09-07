package com.daou.security.service;

import com.daou.security.entity.User;
import com.daou.security.model.UserModel;

public interface UserService {
    User findByEmail(String email);
    void saveUser(User user);
    UserModel create();
}
