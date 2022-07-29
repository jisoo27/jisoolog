package com.jisoolog.api.controller;

import com.jisoolog.api.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // 로그를 사용할 수 있음
@RestController
public class PostController {

    @PostMapping ("/posts")
    public String post(@RequestBody PostCreate params) {
        // 실제 서버에서 받을 때에는 @RequestParam의 형태로 받을 수 있다.
        log.info("params={}", params.toString()); // 로그 찍어보기
        return "Hello World";
    }
}
