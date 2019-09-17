package com.daou.jpa.service;

import com.daou.jpa.entity.User;
import com.daou.jpa.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserModel create();
    List<UserModel> getUserList();
    List<UserModel> delete();
    void delete(User user);
    Optional<User> getUserById(long id);
}
