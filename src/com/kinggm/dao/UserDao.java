package com.kinggm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kinggm.model.User;

/*
 * �û�Dao�� (Data Access Object ���ݷ��ʶ��� ��һ�������������ݿ�ӿ�)
 * */
public class UserDao {

	
	
	/*
	 * ��¼��֤
	 * */
	public User login(Connection con,User user)throws Exception {
		User resultUser=null;
		String sql="select * from t_user where userName=? and password=?  ";
		PreparedStatement psmt=con.prepareStatement(sql);
		
		psmt.setString(1, user.getName());
		psmt.setString(2, user.getPassword());
		
		ResultSet rs=psmt.executeQuery();
		
		if(rs.next()) {
			resultUser=new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setName(rs.getString("userName"));
			resultUser.setPassword("password");
			
		}
		
		return resultUser;
		
		
	}
	
	
	
}
