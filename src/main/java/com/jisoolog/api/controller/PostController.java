package com.jisoolog.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j // 로그를 사용할 수 있음
@RestController
public class PostController {

    // Http method
    // GET, POST, PUT, PATCH, DELETE, OPTIONS, HEAD, TRACE, CONNECT
    // 글 등록
    // POST Method

    @PostMapping ("/posts")
    public String post(@RequestParam Map<String, String> params) {
        // 실제 서버에서 받을 때에는 @RequestParam의 형태로 받을 수 있다.
        log.info("params={}", params); // 로그 찍어보기
        return "Hello World";
    }
}
