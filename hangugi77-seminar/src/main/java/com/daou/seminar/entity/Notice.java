package com.daou.seminar.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    @Column(length = 10485760)
    private String content;

    private String author;
    private Date createdAt;
    private Date modifiedAt;

    @PreUpdate
    public void updateCreatedAt() {
        modifiedAt = new Date();
    }
}
