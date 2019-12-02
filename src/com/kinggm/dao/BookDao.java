package com.kinggm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kinggm.model.Book;
import com.kinggm.util.StringUtil;

/**
 * ͼ��Dao�� ����: kinggm E-mail:82674246@qq.com ʱ��: 2019��6��12�� ����5:06:15
 * 
 */

public class BookDao {
	// ͼ�����
	public int add(Connection con,Book book)throws Exception {
		String sql="insert into t_book values(null,?,?,?,?,?,?)";
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setString(1, book.getBookName());
		psmt.setString(2, book.getAuthor());
		psmt.setString(3, book.getSex());
		psmt.setFloat(4, book.getPrice());
		psmt.setInt(5, book.getBookTypeId());
		psmt.setString(6, book.getBookDesc());
		
		return psmt.executeUpdate();
	}

	
	//ͼ����Ϣ��ѯ
	public ResultSet list(Connection con,Book book)throws Exception {
		StringBuffer sb=new StringBuffer("select * from t_book b,t_bookType bt where b.bookTypeId=bt.id");
		if(StringUtil.isNotEmpty(book.getBookName())) {
			sb.append(" and b.bookName like '%"+book.getBookName()+"%'");
			
		}
		if(StringUtil.isNotEmpty(book.getAuthor())) {
			sb.append(" and b.author like '%"+book.getAuthor()+"%'");
			
		}
		if(book.getBookTypeId()!=null&&book.getBookTypeId()!=-1) {
			sb.append(" and b.bookTypeId like '%"+book.getBookTypeId()+"%'");
			
		}
		
		 PreparedStatement psmt=con.prepareStatement(sb.toString());
		 return psmt.executeQuery(); 
		
	}
	
	//ɾ��ͼ��
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from t_book where id=?";
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setString(1, id);
		return	psmt.executeUpdate();
		
		
	}
	
	
	
	//ɾ��ͼ��
	public int update(Connection con,Book book)throws Exception{
		String sql="update t_book set bookName=?,author=?,sex=?,price=?,bookDesc=?,bookTypeId=? where id=?";
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setString(1, book.getBookName());
		psmt.setString(2, book.getAuthor());
		psmt.setString(3, book.getSex());
		psmt.setFloat(4, book.getPrice());
		psmt.setString(5, book.getBookDesc());
		psmt.setInt(6, book.getBookTypeId());
		psmt.setInt(7, book.getId());
		return	psmt.executeUpdate();
		
		
	}
	
	//ָ��ͼ��������Ƿ����ͼ��
	
	public boolean existBookTypeId(Connection con,String bookTypeId)throws Exception{
		String sql="select * from t_book where bookTypeId=?";
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setString(1, bookTypeId);
		ResultSet rs=psmt.executeQuery();
		return rs.next();
		
		
		
	}
	
	
	
}
