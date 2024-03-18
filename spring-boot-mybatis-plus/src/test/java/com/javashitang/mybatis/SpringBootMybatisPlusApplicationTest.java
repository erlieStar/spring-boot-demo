package com.javashitang.mybatis;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javashitang.mybatis.dao.BookDao;
import com.javashitang.mybatis.entity.Book;
import com.javashitang.mybatis.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class SpringBootMybatisPlusApplicationTest {

    @Resource
    private BookMapper bookMapper;
    @Resource
    private BookDao bookDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() {
        Book book = this.bookMapper.selectById(1);
        System.out.println(book);
    }

    @Test
    public void test2() {
        Book book = bookDao.selectById(1);
        System.out.println(book);
    }

    @Test
    public void test3() {
        Page<Book> page = new Page<>(0, 2);
        IPage<Book> bookIPage = bookMapper.selectAll(page);
        System.out.println(bookIPage.getRecords());
    }

    @Test
    public void test4() {
        Page<Book> page = new Page<>(1, 2);
        IPage<Book> bookIPage = bookMapper.selectAll(page);
        System.out.println(bookIPage.getRecords());
    }

    @Test
    public void test5() {
        Page<Book> page = new Page<>(2, 2);
        IPage<Book> bookIPage = bookMapper.selectAll(page);
        System.out.println(bookIPage.getTotal());
        System.out.println(bookIPage.getRecords());
    }

}
