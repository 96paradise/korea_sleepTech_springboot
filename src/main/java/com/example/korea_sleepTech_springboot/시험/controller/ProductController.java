package com.example.korea_sleepTech_springboot.시험.controller;

import com.example.korea_sleepTech_springboot.시험.common.ApiMappingPattern;
import com.example.korea_sleepTech_springboot.dto.response.ResponseDto;
import com.example.korea_sleepTech_springboot.시험.dto.request.ProductCreateRequestDto;
import com.example.korea_sleepTech_springboot.시험.dto.request.ProductUpdateRequestDto;
import com.example.korea_sleepTech_springboot.시험.dto.response.ProductResponseDto;
import com.example.korea_sleepTech_springboot.시험.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiMappingPattern.PRODUCT_API)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseDto<ProductResponseDto>> createProduct(@RequestBody ProductCreateRequestDto dto) {
        try {
            ResponseDto<ProductResponseDto> product = productService.createProduct(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        List<ProductResponseDto> products = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<ProductResponseDto>> getProductById(@PathVariable Long id) {
        ResponseDto<ProductResponseDto> product = productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<ProductResponseDto>> updateProduct(@PathVariable Long id, @RequestBody ProductUpdateRequestDto dto) {
        ResponseDto<ProductResponseDto> product = productService.updateProduct(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Void>> deleteProduct(@PathVariable Long id) {
        ResponseDto<Void> response = productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
