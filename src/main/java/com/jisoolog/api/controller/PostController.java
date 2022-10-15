package com.jisoolog.api.controller;

import com.jisoolog.api.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@Slf4j // 로그를 사용할 수 있음
@RestController
public class PostController {

    @PostMapping ("/posts")
    public Map<String, String> post(@RequestBody @Valid PostCreate params) {
         return Map.of(); // Map 생성 초기화해주는 of
    }
}
