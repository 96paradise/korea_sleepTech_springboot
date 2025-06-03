package com.example.korea_sleepTech_springboot.teamproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schoolApplicationId;

    @Enumerated(EnumType.STRING)
    private SchoolApplicationStatus schoolApplicationStatus = SchoolApplicationStatus.PENDING;

    private String schoolName;
    private String schoolAddress;
    private String schoolContactNumber;
    private String schoolAdminName;
    private String schoolAdminPhoneNumber;
    private String schoolAdminEmail;

    private LocalDateTime createdAt = LocalDateTime.now();

    public enum SchoolApplicationStatus {
        PENDING, APPROVED, REJECTED
    }
}
