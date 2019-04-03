package com.hanlin.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hanlin.Application;

//运行测试用例
@RunWith(SpringJUnit4ClassRunner.class)
//指定SpringBoot启动类
@SpringBootTest(classes = Application.class)
public class RedisTest2 {

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
	@Test
	public void test1() {
		User user=new User();
		user.setId(1);
		user.setName("莉莉");
		redisTemplate.opsForValue().set("user", user);
		
	}
	
	
	
	
}
