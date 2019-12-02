package com.kinggm.model;
/*
 * 用户实体
 * */
public class User {

	
	
	private int id; //编号
	private String name;//用户名
	private String password;//密码
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//无参构造方法 （防止new 无参实例报错）
	public User() {
		super();
		
	}
	
	//有参构造方法
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
