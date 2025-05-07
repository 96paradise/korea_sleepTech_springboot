package com.example.korea_sleepTech_springboot.시험.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProductCreateRequestDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
