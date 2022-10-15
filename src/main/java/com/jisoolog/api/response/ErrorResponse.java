package com.jisoolog.api.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * {
 *     "code" : "400"
 *     "message" : "잘못된 요청입니다."
 *     "validation" : (어떤 필드가 잘못되었는지 알려줄려면)(가능하면 명확하게 피드백해주는게 좋음) {
 *         (배열형태로)
 *         "title" : "값을 입력해주세요"
 *     }
 * }
 */


@Getter
@RequiredArgsConstructor
public class ErrorResponse {

    private final String code;
    private final String message;
    private final Map<String, String> validation = new HashMap<>();

    public void addValidation(String field, String errorMessage) {
        this.validation.put(field, errorMessage);
    }

}
