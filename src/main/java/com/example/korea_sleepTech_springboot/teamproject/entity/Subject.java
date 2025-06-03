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
public class Subject {
    @Id
    private String subjectId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    private String subjectName;
    private String grade;
    private String semester;

    @Enumerated(EnumType.STRING)
    private Affiliation affiliation;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Integer maxEnrollment;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public enum Affiliation {
        LIBERAL_ARTS, NATURAL_SCIENCES
    }

    public enum Category {
        COMPLETED, NOT_SELECTED
    }
}
