package com.daou.security.service;

import com.daou.security.encoder.TestPlainPasswordEncoder;
import com.daou.security.entity.Role;
import com.daou.security.entity.User;
import com.daou.security.model.UserModel;
import com.daou.security.repository.RoleRepository;
import com.daou.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TestPlainPasswordEncoder testPlainPasswordEncoder;

    @Autowired
    private UserService2 userService2;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(testPlainPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);

        m1();
    }

    private void m1() {
        for(int i = 61; i < 70; i++) {
            User u = new User();
            u.setActive(1);
            u.setPassword(String.valueOf(i));
            u.setEmail(String.valueOf(i));
            u.setLastName(String.valueOf(i));
            u.setName(String.valueOf(i));
            Role uRole = roleRepository.findByRole("ADMIN");
            u.setRoles(new HashSet<Role>(Arrays.asList(uRole)));
            userRepository.save(u);
        }

        userService2.saveUser();
    }

    public UserModel create() {
        User user = new User();
        user.setActive(1);
        user.setPassword("ffff");
        user.setEmail("hangugi77@naver.com");
        user.setLastName("mskw");
        user.setName("kwak");
        userRepository.save(user);
        return new UserModel();
    }
}
