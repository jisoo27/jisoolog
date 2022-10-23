package com.jisoolog.api.controller;

import com.jisoolog.api.request.PostCreate;
import com.jisoolog.api.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j // 로그를 사용할 수 있음
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping ("/posts")
    public void post(@RequestBody @Valid PostCreate request) {
        postService.write(request);
    }
}
