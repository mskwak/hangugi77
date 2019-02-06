package com.daou.security.service;

import com.daou.security.encoder.TestPlainPasswordEncoder;
import com.daou.security.entity.Role;
import com.daou.security.entity.User;
import com.daou.security.repository.RoleRepository;
import com.daou.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl2 implements UserService2 {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TestPlainPasswordEncoder testPlainPasswordEncoder;

//    @Transactional
    public void saveUser() {
        for(int i = 71; i < 80; i++) {

            if(i == 79) {
                throw new  RuntimeException();
            }
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
    }
}
