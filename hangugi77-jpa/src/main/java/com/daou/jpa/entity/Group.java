package com.daou.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "test_group")
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

//    @OneToMany(mappedBy = "group", orphanRemoval = true)
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<User> userList = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }
}