package com.javashitang.mybatis.entity;

import lombok.Data;

@Data
public class Book {

    private Integer id;

    private Integer authorId;

    private String name;

    public Book(Integer id, Integer authorId, String name) {
        this.id = id;
        this.authorId = authorId;
        this.name = name;
    }
}