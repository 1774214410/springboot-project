package com.example.demo05;

import com.example.demo05.mapper.UserMapper;
import com.example.demo05.model.User;
import com.example.demo05.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo05ApplicationTests {

	@Autowired
	RedisUtil redisUtil;


	@Resource
	protected UserMapper userMapper;

	@Test
	public void contextLoads() {

		List<User> userList = userMapper.findAll();
		redisUtil.set("testKey",userList);
		return ;

	}

	@Test
	public void testRedis(){
		long nowTime = System.currentTimeMillis();
		List<User> userList = userMapper.findAll();
		long lastTime = System.currentTimeMillis();
		System.out.print("数据库中查询经历的时间是："+(lastTime-nowTime));
	}

	@Test
	public void testRedis1(){
		long nowTime = System.currentTimeMillis();
		List<User> userList = (List<User>) redisUtil.get("testKey");
		long lastTime = System.currentTimeMillis();
		System.out.print("Redis查询经历的时间是："+(lastTime-nowTime));
	}

	@Test
	public void testRedis2(){
		long time = redisUtil.getExpire("testKey");
		System.out.print("testKey过期的时间还有"+time);
	}

	@Test
	public void testRedis3(){
		User user = new User();
		user.setId(6);
		user.setUser_name("刘正文");
		user.setUser_age(19);
		redisUtil.set("user",user,180);
		//long time = redisUtil.set("user",)
		//System.out.print("testKey过期的时间还有"+time);
	}

}
