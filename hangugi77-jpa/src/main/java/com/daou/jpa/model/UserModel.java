package com.daou.jpa.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserModel {
    private long id;
    private String name;
    private String email;
    private long groupId;
}
