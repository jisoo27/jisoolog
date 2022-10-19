package com.jisoolog.api.service;

import com.jisoolog.api.domain.Post;
import com.jisoolog.api.repository.PostRepository;
import com.jisoolog.api.request.PostCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService { // service Layer

    private final PostRepository postRepository;

    public void write(PostCreate postCreate) {
        // repository.save(postCreate) X 불가능
        // PostCreate 는 RequestDto 형태라서 저 안에 save 메서드에 넣어줄수없다.
        // RequestDto => entity 로 변환해주어야 함.

        Post post = new Post(postCreate.getTitle(), postCreate.getContent());
        postRepository.save(post);
    }
}
