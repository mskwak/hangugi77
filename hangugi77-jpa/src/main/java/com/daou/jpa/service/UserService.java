package com.daou.jpa.service;

import com.daou.jpa.entity.User;
import com.daou.jpa.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel create();
    List<UserModel> get();
    List<UserModel> delete();
    void delete(User user);
}
