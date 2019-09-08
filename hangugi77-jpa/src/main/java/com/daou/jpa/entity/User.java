package com.daou.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "test_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    private Group group;

    public User(String name, String email, Group group) {
        this.name = name;
        this.email = email;
        this.group = group;
    }
}
