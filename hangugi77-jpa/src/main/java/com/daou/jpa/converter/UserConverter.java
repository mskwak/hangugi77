package com.daou.jpa.converter;

import com.daou.jpa.entity.User;
import com.daou.jpa.model.UserModel;

public interface UserConverter {
    UserModel convertUserToUserModel(User user);
    User convertUserModelToUser(UserModel userModel);
}
