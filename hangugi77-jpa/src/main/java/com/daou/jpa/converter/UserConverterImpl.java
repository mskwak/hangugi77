package com.daou.jpa.converter;

import com.daou.jpa.entity.User;
import com.daou.jpa.model.UserModel;
import com.daou.jpa.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserConverterImpl implements UserConverter {
    @NonNull
    private final UserService userService;

    @Override
    public UserModel convertUserToUserModel(User user) {
        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        userModel.setName(user.getName());
        userModel.setEmail(user.getEmail());
        userModel.setGroupId(user.getGroup().getId());
        return userModel;
    }

    @Override
    public User convertUserModelToUser(UserModel userModel) {
        User user = userService.getUserById(userModel.getId()).orElseThrow(() -> new RuntimeException());
        user.setEmail(userModel.getEmail());
        user.setName(userModel.getName());
        return user;
    }
}
