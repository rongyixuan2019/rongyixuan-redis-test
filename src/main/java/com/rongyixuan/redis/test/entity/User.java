/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: User.java 
 * @Prject: rongyixuan-redis-test
 * @Package: com.rongyixuan.redis.test.entity 
 * @Description: TODO
 * @author: 86155   
 * @date: 2019年12月9日 上午8:46:29 
 * @version: V1.0   
 */
package com.rongyixuan.redis.test.entity;

import java.io.Serializable;

/** 
 * @ClassName: User 
 * @Description: TODO
 * @author: 86155
 * @date: 2019年12月9日 上午8:46:29  
 */
public class User implements Serializable{

	private Integer id;
	private String name;
	private String sex;
	private String phone;
	private String email;
	private String birthday;
	/** 
	 * @Title:User
	 * @Description:TODO  
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	/** 
	 * @Title:User
	 * @Description:TODO 
	 * @param id
	 * @param name
	 * @param sex
	 * @param phone
	 * @param email
	 * @param birthday 
	 */
	public User(Integer id, String name, String sex, String phone, String email, String birthday) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
	}
	/* (non Javadoc) 
	 * @Title: toString
	 * @Description: TODO
	 * @return 
	 * @see java.lang.Object#toString() 
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", phone=" + phone + ", email=" + email
				+ ", birthday=" + birthday + "]";
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}
