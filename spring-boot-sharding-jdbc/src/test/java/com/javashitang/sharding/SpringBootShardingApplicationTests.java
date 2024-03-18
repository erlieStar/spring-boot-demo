package com.javashitang.sharding;

import com.javashitang.sharding.dao.OrderDao;
import com.javashitang.sharding.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringBootShardingApplicationTests {

	@Autowired
	OrderDao orderDao;

	@Test
	public void test1() {
		Order order = orderDao.selectByOrderCode("test2013");
	}

}

