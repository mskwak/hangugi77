package com.daou.jpa.service;

import com.daou.jpa.entity.Group;
import com.daou.jpa.entity.User;
import com.daou.jpa.model.UserModel;
import com.daou.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupService groupService;

    @Transactional
    public UserModel create() {
        User user = new User();
        user.setName("곽면순");
        user.setEmail("hangugi77@gmail.com");
        user = userRepository.save(user);

        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        userModel.setEmail(user.getEmail());
        userModel.setName(user.getName());

        return userModel;
    }

    @Override
    @Transactional
    public List<UserModel> get() {
        List<User> list = userRepository.findAll();
        List<UserModel> userModelList = new ArrayList<>();
        list.stream().forEach(l -> {
            UserModel userModel = new UserModel();
            userModel.setId(l.getId());
            userModel.setName(l.getName());
            userModel.setEmail(l.getEmail());
            userModel.setGroupId(l.getGroup().getId());
            userModelList.add(userModel);
        });
        return userModelList;
    }

    @Override
    @Transactional
    public List<UserModel> delete() {
        List<User> list = userRepository.findAll();
        list.stream().forEach(user -> {
            long groupId = user.getGroup().getId();
            if(groupId == 2) {
                userRepository.delete(user);
            }
        });

        return get();
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
