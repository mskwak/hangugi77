package com.daou.session.controller;

import com.daou.session.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@Slf4j
@RestController
public class SessionContorller {
    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String helloRoot(HttpSession httpSession) {
        System.out.println(httpSession.getId());
        return "hello /";
    }

    @GetMapping("/hello")
    public String helloHello() {
        return "hello /hello";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        loginService.clearSession(httpSession.getId());
        return "login";
    }
}