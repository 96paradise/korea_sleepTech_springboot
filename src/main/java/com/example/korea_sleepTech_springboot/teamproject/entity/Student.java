package com.example.korea_sleepTech_springboot.teamproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    private String studentId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    private String username;
    private String password;
    private String studentNumber;
    private String name;
    private String grade;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Affiliation affiliation;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ENROLLED;

    private Integer admissionYear;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public enum Affiliation {
        LIBERAL_ARTS, NATURAL_SCIENCES
    }

    public enum Status {
        ENROLLED, NOT_ENROLLED, GRADUATED
    }
}
