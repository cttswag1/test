package com.hanlin.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hanlin.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ResisTest {
    @Autowired
    private StringRedisTemplate redisTemplate;
    
    @Test
    public void test1() {
    	//redisTemplate.opsForValue().set("name", "jarry");
		
		 String value=redisTemplate.opsForValue().get("name");
		 System.out.println(value);
		 
    }
    
    @Test
	public void test2() throws JSONException {
		JSONObject json = new JSONObject();
		json.put("name", "张三");
		json.put("sex", "女");
		/*
		 * User user = new User(); user.setId(1); user.setName("丽丽");
		 */
		
		redisTemplate.opsForList().leftPush("student", json.toString());
	}
	
	@Test
	public void test3() throws JSONException {
		/*List<String> range = redisTemplate.opsForList().range("student", 0, -1);
		for (String string : range) {
			System.out.println(string);
		}*/
		
		Collection<String> keys = new ArrayList<String>();
        keys.add("multi1");
        keys.add("multi2");
        keys.add("multi3");
        List<String> multiGet = redisTemplate.opsForValue().multiGet(keys);
        for (String string : multiGet) {
			System.out.println(string);
		}
        
	
	}
}
