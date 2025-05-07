package com.example.korea_sleepTech_springboot.시험.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto<D> {
    private boolean result;
    private String message;
    private D data;

    // 성공 응답 생성
    public static <D> ResponseDto<D> setSuccess(String message, D data) {
        return new ResponseDto<>(true, message, data);
    }

    // 실패 응답 생성
    public static <D> ResponseDto<D> setFailed(String message) {
        return new ResponseDto<>(false, message, null);
    }
}
