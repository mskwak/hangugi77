package com.daou.security.service;

import com.daou.security.entity.User;

public interface UserService {
    public User findByEmail(String email);
    public void saveUser(User user);
}
