package com.example.korea_sleepTech_springboot.service.implementations;

import com.example.korea_sleepTech_springboot.service.MailService;
import reactor.core.publisher.Mono;

public class MailServiceImpl implements MailService {
    @Override
    public Mono<String> sendSimpleMessage(String email) {
        return null;
    }
}
