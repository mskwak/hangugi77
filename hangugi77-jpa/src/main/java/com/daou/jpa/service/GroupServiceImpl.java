package com.daou.jpa.service;

import com.daou.jpa.entity.Group;
import com.daou.jpa.entity.User;
import com.daou.jpa.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private UserService userService;
    @Autowired
    private GroupRepository groupRepository;

    @Override
    @Transactional
    public void delete() {
        List<Group> groupList = groupRepository.findAll();

        for(Group group: groupList) {
            List<User> userList = group.getUserList();
            for(User user: userList) {
                if("김정은".equals(user.getName())) {
                    userService.delete(user);
                }
            }
        }

        for(Group group: groupList) {
            List<User> userList = group.getUserList();
            for(User user: userList) {
                System.out.println(user.getName());
            }
        }

        groupList.stream().filter(group -> group.getId() == 2).forEach(group -> {
            groupRepository.delete(group);
        });
    }
}
