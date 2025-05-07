package com.example.korea_sleepTech_springboot.시험.service;

import com.example.korea_sleepTech_springboot.dto.response.ResponseDto;
import com.example.korea_sleepTech_springboot.시험.dto.request.ProductCreateRequestDto;
import com.example.korea_sleepTech_springboot.시험.dto.request.ProductUpdateRequestDto;
import com.example.korea_sleepTech_springboot.시험.dto.response.ProductResponseDto;
import com.example.korea_sleepTech_springboot.시험.entity.Product;
import com.example.korea_sleepTech_springboot.시험.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ResponseDto<ProductResponseDto> createProduct(ProductCreateRequestDto requestDto) {
        try {
            Product newProduct = new Product(
                    null,
                    requestDto.getName(),
                    requestDto.getDescription(),
                    requestDto.getPrice(),
                    requestDto.getCreated_at(),
                    requestDto.getUpdated_at()
            );

            Product savedProduct = productRepository.save(newProduct);

            ProductResponseDto response = new ProductResponseDto(
                    savedProduct.getId(),
                    savedProduct.getName(),
                    savedProduct.getDescription(),
                    savedProduct.getPrice(),
                    savedProduct.getCreated_at(),
                    savedProduct.getUpdated_at()
            );

            return ResponseDto.setSuccess("새로운 상품이 정상적으로 등록되었습니다.", response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed("상품 등록 중 오류가 발생하였습니다: " + e.getMessage());
        }
    }

    public List<ProductResponseDto> getAllProducts() {
        List<ProductResponseDto> responseDtos = null;
        try {
            List<Product> products = productRepository.findAll();

            responseDtos = products.stream()
                    .map(product -> new ProductResponseDto(
                            product.getId(),
                            product.getName(),
                            product.getDescription(),
                            product.getPrice(),
                            product.getCreated_at(),
                            product.getUpdated_at()
                    ))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseDtos;
    }

    public ResponseDto<ProductResponseDto> getProductById(Long id) {
        try {
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 id의 상품을 찾을 수 없습니다: " + id));

            ProductResponseDto responseDto = new ProductResponseDto(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getPrice(),
                    product.getCreated_at(),
                    product.getUpdated_at()
            );

            return ResponseDto.setSuccess("상품 조회가 완료되었습니다.", responseDto);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed("상품 조회 중 오류가 발생하였습니다: " + e.getMessage());
        }
    }

    public ResponseDto<ProductResponseDto> updateProduct(Long id, ProductUpdateRequestDto dto) {
        try {
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 id의 상품을 찾을 수 없습니다: " + id));

            product.setName(dto.getName());
            product.setDescription(dto.getDescription());
            product.setPrice(dto.getPrice());

            Product updatedProduct = productRepository.save(product);

            ProductResponseDto responseDto = new ProductResponseDto(
                    updatedProduct.getId(),
                    updatedProduct.getName(),
                    updatedProduct.getDescription(),
                    updatedProduct.getPrice(),
                    updatedProduct.getCreated_at(),
                    updatedProduct.getUpdated_at()
            );

            return ResponseDto.setSuccess("상품 수정이 완료되었습니다.", responseDto);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed("상품 수정 중 오류가 발생하였습니다: " + e.getMessage());
        }
    }

    public ResponseDto<Void> deleteProduct(Long id) {
        try {
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 id의 상품을 찾을 수 없습니다: " + id));

            productRepository.delete(product);
            return ResponseDto.setSuccess("상품 삭제가 완료되었습니다.", null);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed("상품 삭제 중 오류가 발생하였습니다: " + e.getMessage());
        }
    }
}
