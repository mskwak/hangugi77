package com.daou.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShiroApplication {

    public static void main(String[] args) {
        Subject currentUser = SecurityUtils.getSubject();

        if(currentUser == null) {
            System.out.println("null");
        }

//        Session session = currentUser.getSession();

//        if(! currentUser.isAuthenticated()) {
//            System.out.println("xx");
//            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("mskw", "ffff");
//            usernamePasswordToken.setRememberMe(true);
//            currentUser.login(usernamePasswordToken);
//        }



        SpringApplication.run(ShiroApplication.class, args);

    }
}
