//package com.daou.seminar.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.ReactiveRedisTemplate;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//
//@Configuration
//public class RedisConfig {
//	@Autowired
//	private ReactiveRedisConnectionFactory redisConnectionFactory;
//
//	@Bean
//	public LettuceConnectionFactory lettuceConnectionFactory()  {
//		return new LettuceConnectionFactory();
//	}
//
//	@Bean
//	public ReactiveRedisTemplate<String, String> reactiveRedisTemplate(ReactiveRedisConnectionFactory reactiveRedisConnectionFactory) {
//		return new ReactiveRedisTemplate<>(reactiveRedisConnectionFactory, RedisSerializationContext.string());
//	}
//}
