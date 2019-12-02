package com.kinggm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kinggm.model.User;

/*
 * 用户Dao类 (Data Access Object 数据访问对象 是一个面向对象的数据库接口)
 * */
public class UserDao {

	
	
	/*
	 * 登录验证
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
