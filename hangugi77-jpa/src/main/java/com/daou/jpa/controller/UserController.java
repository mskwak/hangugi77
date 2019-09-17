package com.daou.jpa.controller;

import com.daou.jpa.model.UserModel;
import com.daou.jpa.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    @NonNull
    private final UserService userService;

    @GetMapping(value = "/user/list")
    public List<UserModel> getUserList() {
        return userService.getUserList();
    }

    @GetMapping(value = "/delete/{id}")
    public List<UserModel> delete(@PathVariable long id) {
        log.info("id: {}", id);
        return userService.delete();
    }
}
