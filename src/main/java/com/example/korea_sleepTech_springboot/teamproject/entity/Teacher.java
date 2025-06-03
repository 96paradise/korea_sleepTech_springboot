package com.example.korea_sleepTech_springboot.teamproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
    @Id
    private String teacherId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private String subject;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}

