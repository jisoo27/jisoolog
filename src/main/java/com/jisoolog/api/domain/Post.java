package com.jisoolog.api.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // JPA가 관리할 객체
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC) // Protected 로 설정해 줄 경우 생성자가 생기지 않는다.
public class Post {

    @Id // 데이터베이스 primary key 와 매핑
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
