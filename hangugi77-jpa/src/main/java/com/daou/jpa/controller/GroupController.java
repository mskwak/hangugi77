package com.daou.jpa.controller;

import com.daou.jpa.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping(value = "/delete/group/{id}")
    public void deleteGroup(@PathVariable long id) {
        groupService.delete(id);
    }
}
