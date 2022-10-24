package com.jisoolog.api.controller;

import com.jisoolog.api.domain.Post;
import com.jisoolog.api.request.PostCreate;
import com.jisoolog.api.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/posts/{postId}")
    public Post get(@PathVariable(name = "postId") Long id) {
        Post post = postService.get(id);
        return post;
    }

}

/* /posts -> 글 전체 조회 (검색 + 페이징)
 * /posts/{postId} -> 글 한개만 조회
 */