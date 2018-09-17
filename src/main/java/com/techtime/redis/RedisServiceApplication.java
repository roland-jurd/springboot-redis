package com.techtime.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.techtime.redis.model.User;


@SpringBootApplication
public class RedisServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(RedisServiceApplication.class, args);
	}
}
