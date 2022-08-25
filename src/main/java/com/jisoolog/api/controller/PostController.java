package com.jisoolog.api.controller;

import com.jisoolog.api.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j // 로그를 사용할 수 있음
@RestController
public class PostController {

    @PostMapping ("/posts")
    public Map<String, String> post(@RequestBody @Valid PostCreate params, BindingResult result) {
        // 실제 서버에서 받을 때에는 @RequestParam의 형태로 받을 수 있다.
        if (result.hasErrors()) { // 에러가 존재할 경우
            List<FieldError> fieldErrors = result.getFieldErrors();
            FieldError firstFieldError = fieldErrors.get(0);
            String fieldName = firstFieldError.getField(); // title
            String errorMessage = firstFieldError.getDefaultMessage();// ... 에러메세지

            Map<String, String> error = new HashMap<>();
            error.put(fieldName, errorMessage);
            return error;
        }

        return Map.of(); // Map 생성 초기화해주는 of
    }
}
