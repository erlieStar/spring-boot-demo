package com.javashitang.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javashitang.mybatis.entity.Book;

/**
 * @Author lilimin
 * @Date 2022/5/6
 */
public interface BookMapper extends BaseMapper<Book> {

    IPage<Book> selectAll(Page<Book> page);
}
