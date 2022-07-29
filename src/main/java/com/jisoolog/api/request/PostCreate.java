package com.jisoolog.api.request;

public class PostCreate { // 요청을 받아주는 그 클래스를 가지고 있는 request 페키지

    // 요청이 넘어왔을 때 이 클래스 변수에 할당해주어야 한다
    // 그럴려면 setter 메서드 필요

    public String title;
    public String content;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PostCreate{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
