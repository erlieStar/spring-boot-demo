package com.javashitang.mybatis.entity;

import lombok.Data;

@Data
public class Book {
    private Integer id;

    private Integer authorid;

    private String name;

    public Book(Integer id, Integer authorid, String name) {
        this.id = id;
        this.authorid = authorid;
        this.name = name;
    }
}