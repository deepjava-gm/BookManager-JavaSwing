package com.kinggm.model;

/*
 *  ͼ�����ʵ��
 * */
public class BookType {

	
	
	public BookType(String bookTypeName, String bookTypeDesc) {
		super();
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
	}
	//�˹��췽������ȱ��
	public BookType() {
		super();
		
	}
	
	public BookType(int id, String bookTypeName, String bookTypeDesc) {
		super();
		this.id = id;
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
	}

	private int id; //���
	private String bookTypeName; //ͼ�������
	private String bookTypeDesc; //��ע
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getBookTypeDesc() {
		return bookTypeDesc;
	}
	public void setBookTypeDesc(String bookTypeDesc) {
		this.bookTypeDesc = bookTypeDesc;
	}
	@Override
	public String toString() {
		return bookTypeName;
	}
	
	
	
	
}
