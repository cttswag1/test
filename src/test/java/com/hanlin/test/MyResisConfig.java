package com.hanlin.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class MyResisConfig {

	@Bean 
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
	{ 
		RedisTemplate<Object, Object> template = new RedisTemplate<>(); 
		//使用Jackson2JsonRedisSerializer 自带序列化 
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class); 
		// value值的序列化采用jackson2JsonRedisSerializer 
		template.setValueSerializer(jackson2JsonRedisSerializer); 
		template.setHashValueSerializer(jackson2JsonRedisSerializer); 
		// key的序列化采用StringRedisSerializer 
		template.setKeySerializer(new StringRedisSerializer()); 
		template.setHashKeySerializer(new StringRedisSerializer()); 
		template.setConnectionFactory(redisConnectionFactory); 
		return template; 
	}
}
