package com.kinggm.model;
/*
 * �û�ʵ��
 * */
public class User {

	
	
	private int id; //���
	private String name;//�û���
	private String password;//����
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//�޲ι��췽�� ����ֹnew �޲�ʵ������
	public User() {
		super();
		
	}
	
	//�вι��췽��
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
