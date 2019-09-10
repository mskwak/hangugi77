package com.daou.jpa.controller;

import com.daou.jpa.model.UserModel;
import com.daou.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/get")
    public List<UserModel> get() {
        return userService.get();
    }

    @GetMapping(value = "/delete")
    public List<UserModel> delete() {
        return userService.delete();
    }
}
