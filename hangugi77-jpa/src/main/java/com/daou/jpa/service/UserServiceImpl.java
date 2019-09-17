package com.daou.jpa.service;

import com.daou.jpa.converter.UserConverter;
import com.daou.jpa.entity.User;
import com.daou.jpa.model.UserModel;
import com.daou.jpa.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @NonNull
    private final UserRepository userRepository;
    @NonNull
    private final GroupService groupService;
    @NonNull
    private final UserConverter userConverter;

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
    public List<UserModel> getUserList() {
        return userRepository
                .findAll()
                .stream()
                .map(u -> userConverter.convertUserToUserModel(u))
                .collect(Collectors.toList());
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

        return getUserList();
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }
}
