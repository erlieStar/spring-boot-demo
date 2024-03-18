package com.javashitang.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.javashitang.sharding.mapper")
@SpringBootApplication
public class SpringBootShardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootShardingApplication.class, args);
	}

}

