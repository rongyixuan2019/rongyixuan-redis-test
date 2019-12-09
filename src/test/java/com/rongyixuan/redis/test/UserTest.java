/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: UserTest.java 
 * @Prject: rongyixuan-redis-test
 * @Package: com.rongyixuan.redis.test 
 * @Description: TODO
 * @author: 86155   
 * @date: 2019年12月9日 上午8:50:08 
 * @version: V1.0   
 */
package com.rongyixuan.redis.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rongyixuan.redis.test.entity.User;
import com.xuanxuan.common.DateUtil;
import com.xuanxuan.common.RandomUtil;
import com.xuanxuan.common.StringUtil;

/** 
 * @ClassName: UserTest 
 * @Description: TODO
 * @author: 86155
 * @date: 2019年12月9日 上午8:50:08  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-redis.xml")
public class UserTest {
	
	@Resource
	private RedisTemplate RedisTemplate;
	
	/**
	 * 生成50000个user对象
	 * @Title: testUser 
	 * @Description: TODO
	 * @return: void
	 */
	@Test
	public void testUser() {
		for (int i = 1; i <= 50000; i++) {
			//随机生成名字
			String name = StringUtil.randomChineseString(3);
			//随机生成性别
			String sex = StringUtil.RandomSex();
			//随机生成手机号
			String phone = "13"+RandomUtil.randomNumber(9);
			//随机生成邮箱
			String email = StringUtil.RandomEmail();
			//随机生成18-70岁之间，即日期从1949年到2001年之间生日
			Calendar c = Calendar.getInstance();
			c.set(1949, 0, 0);
			/* c.get(1949); */
			Calendar c2 = Calendar.getInstance();
			c.set(2001, 0, 0);
			/* c2.get(2001); */
			Date birthday = DateUtil.randomDate(c.getTime(), c2.getTime());
			//创建对象并赋值
			User user = new User(i, name, sex, phone, email, birthday+"");
			System.out.println(user);
			
		}
	}
	
	/**
	 * 用list存储UserJDK的方法
	 * @Title: testUserJDK 
	 * @Description: TODO
	 * @return: void
	 */
	@Test
	public void testUserJDK() {
		List<User> ulist = new ArrayList();
		for (int i = 1; i <= 50000; i++) {
			//随机生成名字
			String name = StringUtil.randomChineseString(3);
			//随机生成性别
			String sex = StringUtil.RandomSex();
			//随机生成手机号
			String phone = "13"+RandomUtil.randomNumber(9);
			//随机生成邮箱
			String email = StringUtil.RandomEmail();
			//随机生成18-70岁之间，即日期从1949年到2001年之间生日
			Calendar c = Calendar.getInstance();
			c.set(1949, 0, 0);
			/* c.get(1949); */
			Calendar c2 = Calendar.getInstance();
			c.set(2001, 0, 0);
			/* c2.get(2001); */
			Date birthday = DateUtil.randomDate(c.getTime(), c2.getTime());
			//创建对象并赋值
			User user = new User(i, name, sex, phone, email, birthday+"");
			System.out.println(user);
			ulist.add(user);
		}
		//配置RedisTemplate容器
		ListOperations opsForList = RedisTemplate.opsForList();
		//开始时间
		long start = System.currentTimeMillis();
		//开始存储
		opsForList.leftPush("LUJDK", ulist);
		//结束时间
		long end = System.currentTimeMillis();
		System.out.println("testUserJDK--存储用了"+(end-start));
	}
	
	/**
	 * 用list存储UserJSON的方法
	 * @Title: testUserJDK 
	 * @Description: TODO
	 * @return: void
	 */
	@Test
	public void testUserJSON() {
		List<User> ulist = new ArrayList();
		for (int i = 1; i <= 50000; i++) {
			//随机生成名字
			String name = StringUtil.randomChineseString(3);
			//随机生成性别
			String sex = StringUtil.RandomSex();
			//随机生成手机号
			String phone = "13"+RandomUtil.randomNumber(9);
			//随机生成邮箱
			String email = StringUtil.RandomEmail();
			//随机生成18-70岁之间，即日期从1949年到2001年之间生日
			Calendar c = Calendar.getInstance();
			c.set(1949, 0, 0);
			/* c.get(1949); */
			Calendar c2 = Calendar.getInstance();
			c.set(2001, 0, 0);
			/* c2.get(2001); */
			Date birthday = DateUtil.randomDate(c.getTime(), c2.getTime());
			//创建对象并赋值
			User user = new User(i, name, sex, phone, email, birthday+"");
			System.out.println(user);
			ulist.add(user);
		}
		//配置RedisTemplate容器
		ListOperations opsForList = RedisTemplate.opsForList();
		//开始时间
		long start = System.currentTimeMillis();
		//开始存储
		opsForList.leftPush("LUJSON", ulist);
		//结束时间
		long end = System.currentTimeMillis();
		System.out.println("LUJSON--存储用了"+(end-start));
	}
	
	/**
	 * 用hash存储UserJDK的方法
	 * @Title: testUserJDK 
	 * @Description: TODO
	 * @return: void
	 */
	@Test
	public void testUserHash() {
		Map <String , User> uMap = new HashMap<String , User>();
		for (int i = 1; i <= 50000; i++) {
			//随机生成名字
			String name = StringUtil.randomChineseString(3);
			//随机生成性别
			String sex = StringUtil.RandomSex();
			//随机生成手机号
			String phone = "13"+RandomUtil.randomNumber(9);
			//随机生成邮箱
			String email = StringUtil.RandomEmail();
			//随机生成18-70岁之间，即日期从1949年到2001年之间生日
			Calendar c = Calendar.getInstance();
			c.set(1949, 0, 0);
			/* c.get(1949); */
			Calendar c2 = Calendar.getInstance();
			c.set(2001, 0, 0);
			/* c2.get(2001); */
			Date birthday = DateUtil.randomDate(c.getTime(), c2.getTime());
			//创建对象并赋值
			User user = new User(i, name, sex, phone, email, birthday+"");
			System.out.println(user);
			uMap.put(i+"", user);
		}
		//配置RedisTemplate容器
	 HashOperations opsForHash = RedisTemplate.opsForHash();
		//开始时间
		long start = System.currentTimeMillis();
		//开始存储
		opsForHash.putAll("UHash", uMap);
		//结束时间
		long end = System.currentTimeMillis();
		System.out.println("UHash--存储用了"+(end-start));
	}
	
}
