package com.javashitang.mybatis.entity;

import lombok.Data;

@Data
public class Author {
    private Integer id;

    private String name;

    private String phone;

    public Author(Integer id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}