 /**
 * 
 */
package com.kinggm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kinggm.model.BookType;
import com.kinggm.util.StringUtil;

/**
* ����: kinggm  E-mail:82674246@qq.com
* ʱ��: 2019��6��5�� ����5:01:14
* 
*/

public class BookTypeDao {

	
	//ͼ��������
	public int add(Connection con,BookType bookType) throws Exception{
		String sql="insert into t_bookType values(null,?,?)";
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setString(1, bookType.getBookTypeName());
		psmt.setString(2, bookType.getBookTypeDesc());
		
		return psmt.executeUpdate();
	}
	
	
	//��ѯͼ����𼯺�
	public ResultSet list(Connection con,BookType bookType)throws Exception{
		 StringBuffer sb=new StringBuffer("select * from t_bookType");
		 if(StringUtil.isNotEmpty(bookType.getBookTypeName())) {
			 sb.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'");

		 }
		
		 PreparedStatement psmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		 return psmt.executeQuery(); 
	}
	
	
	//ɾ��ͼ�����
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from t_bookType where id=?";
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setString(1, id);
		return psmt.executeUpdate();
		
		
	}
	
	
	//����ͼ�����
	public int update(Connection con,BookType bookType)throws Exception{
		String sql="update t_bookType set bookTypeName=?,bookTypeDesc=? where id=?";
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setString(1, bookType.getBookTypeName());
		psmt.setString(2, bookType.getBookTypeDesc());
		psmt.setInt(3, bookType.getId());
		
		return psmt.executeUpdate();
	}
	
	
	
	
	
	
	
	
}

