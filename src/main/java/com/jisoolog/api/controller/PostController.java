package com.jisoolog.api.controller;

import com.jisoolog.api.request.PostCreate;
import com.jisoolog.api.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@Slf4j // 로그를 사용할 수 있음
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping ("/posts")
    public Map post(@RequestBody @Valid PostCreate request) {
        // 보통 post는 200, 201을 사용
        // 클라이언트 쪽에서 요청하는 post 데이터를 바로 응답값에 json 형태로 넣어주세요 라고 요청하는 경우가 있음

        // Case1. 저장한 데이터 Entity -> response로 응답하기
        // Case2. 저장한 데이터 primary_id -> response로 응답하기
        //        Client 에서는 수신한 id를 post 글 조회 API 를 통해서 글 데이터를 수신받음

        // case3. 응답 필요없는 경우 -> 클라이언트에서 모든 post(글) 데이터 context를 잘 관리한다.

        // bad Case: 서버에서 -> 반드시 이렇게 할꺼다! fix
        //          -> 서버에서 차라리 유연하게 대응하는게 좋다.
        //          -> 한번에 일괄적으로 잘 처리되는 케이스는 없고 -> 잘 관리하는 형태가 중요하다.
        Long postId = postService.write(request);
        return Map.of("postId", postId);
    }
}
