package com.example.korea_sleepTech_springboot.controller;

import com.example.korea_sleepTech_springboot.common.ApiMappingPattern;
import com.example.korea_sleepTech_springboot.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiMappingPattern.BOOK_API)
@RequiredArgsConstructor // final 필드를 매개변수로 가지는 생성자 생성 (+ 의존성 주입의 역할까지 자동 처리)
public class BookController {
    // Service 객체를 주입받아 저장하는 변수
    private final BookService bookService;

//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }

    // 1. 기본 CRUD
    // 1) CREATE - BOOK 생성

    // 2) READ - 전체 책 조회

    // 3) READ - 단건 책 조회 (특정 ID)

    // 4) UPDATE - 책 수정 (특정 ID)

    // 5) DELETE - 책 삭제 (특정 ID)
}