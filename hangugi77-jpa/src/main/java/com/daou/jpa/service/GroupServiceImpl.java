package com.daou.jpa.service;

import com.daou.jpa.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Override
    @Transactional
    public void delete(long id) {
        groupRepository.deleteById(id);
    }
}
