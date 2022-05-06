package com.javashitang.mybatis.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javashitang.mybatis.entity.Book;
import com.javashitang.mybatis.mapper.BookMapper;
import org.springframework.stereotype.Repository;

/**
 * @Author lilimin
 * @Date 2022/5/6
 */
@Repository
public class BookDao extends ServiceImpl<BookMapper, Book> {

    public Book selectById(Integer id) {
        LambdaQueryWrapper<Book> wrapper = Wrappers.lambdaQuery(Book.class)
                .eq(Book::getId, id);
        return this.getOne(wrapper);
    }
}
