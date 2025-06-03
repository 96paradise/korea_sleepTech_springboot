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
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    private String title;
    private String content;

    @Enumerated(EnumType.STRING)
    private TargetAudience targetAudience;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public enum TargetAudience {
        ALL, STUDENT, TEACHER
    }
}

