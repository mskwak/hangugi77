package com.daou.security.service;

import com.daou.security.entity.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
