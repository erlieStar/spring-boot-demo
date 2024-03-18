package com.javashitang.sharding.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javashitang.sharding.entity.Order;
import com.javashitang.sharding.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

/**
 * @Author lilimin
 * @Date 2022/5/6
 */
@Repository
public class OrderDao extends ServiceImpl<OrderMapper, Order> {

    public Order selectByOrderCode(String orderCode) {
        LambdaQueryWrapper<Order> wrapper = Wrappers.lambdaQuery(Order.class)
                .eq(Order::getOrderCode, orderCode);
        return this.getOne(wrapper);
    }
}
