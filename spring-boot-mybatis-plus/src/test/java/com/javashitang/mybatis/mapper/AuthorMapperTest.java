package com.javashitang.mybatis.mapper;

import com.javashitang.mybatis.entity.Author;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author lilimin
 * @date 2022/5/6
 */
public class AuthorMapperTest {
    private static AuthorMapper mapper;

    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(AuthorMapperTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/AuthorMapperTestConfiguration.xml"));
        //you can use builder.openSession(false) to not commit to database
        mapper = builder.getConfiguration().getMapper(AuthorMapper.class, builder.openSession(true));
    }

    @Test
    public void testSelectByPrimaryKey() {
        Author author = mapper.selectByPrimaryKey(1);
        System.out.println(author);
    }
}
