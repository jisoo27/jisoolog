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

    public Long write(PostCreate postCreate) {
        Post post = Post.builder()
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .build();

        postRepository.save(post);
        return post.getId();
    }
}
