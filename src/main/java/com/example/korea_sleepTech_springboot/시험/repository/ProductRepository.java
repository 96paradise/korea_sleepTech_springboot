package com.example.korea_sleepTech_springboot.시험.repository;

import com.example.korea_sleepTech_springboot.시험.entity.Product;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
    List<Product> findByDescription(String description);
    List<Product> findByPrice(BigDecimal price);
}
