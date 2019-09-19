package com.erlie.rabbitmq;

import com.erlie.rabbitmq.hello.DirectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRabbitmqApplicationTests {

	@Autowired
	DirectSender directSender;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test1() {
		directSender.send("" + System.currentTimeMillis());
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

