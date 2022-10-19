package com.jisoolog.api.repository;

import com.jisoolog.api.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // <entity, primary key>
}
