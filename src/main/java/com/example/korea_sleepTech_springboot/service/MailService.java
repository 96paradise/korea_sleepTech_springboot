package com.example.korea_sleepTech_springboot.service;

import reactor.core.publisher.Mono;

public interface MailService {
    Mono<String> sendSimpleMessage(String email);
    Mono<String> ver
}
