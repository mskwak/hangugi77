package com.daou.seminar.model;

import lombok.Data;

@Data
public class Customer {
    public Customer(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    private Long id;
    private String email;
}
