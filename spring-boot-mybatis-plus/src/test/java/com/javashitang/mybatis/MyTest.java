package com.javashitang.mybatis;

import lombok.Data;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lilimin
 * @Date 2022/5/19
 */
public class MyTest {

    @Test
    public void test1() {
        Person person = new Person();
        List<Integer> ids = new ArrayList<>(Arrays.asList(1, 2, 3));
        person.setIds(ids);
        person.setName("test");
        Student student = new Student();
        BeanUtils.copyProperties(person, student);
        System.out.println(student);
        ids.add(1);
        System.out.println(student);
    }

    @Data
    public class Student {
        private String name;
        private List<Integer> ids;
    }

    @Data
    public class Person {
        private String name;
        private List<Integer> ids;
    }
}
