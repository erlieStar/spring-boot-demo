package com.javashitang.mybatis;

import static org.junit.Assert.assertTrue;

import com.javashitang.mybatis.dao.BookDao;
import com.javashitang.mybatis.entity.Book;
import com.javashitang.mybatis.mapper.BookMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
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

}
