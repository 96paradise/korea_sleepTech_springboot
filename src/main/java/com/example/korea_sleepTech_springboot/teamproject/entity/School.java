package com.example.korea_sleepTech_springboot.teamproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schoolId;

    private Integer schoolCode;
    private String schoolName;
    private String schoolAddress;
    private String schoolContactNumber;
    private String schoolPassword;
    private String schoolAdminName;
    private String schoolAdminPhoneNumber;
    private String schoolAdminEmail;
    private LocalDate applicationStartedDay;
    private LocalDate applicationLimitedDay;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}

