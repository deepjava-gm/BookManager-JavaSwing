package com.kinggm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * 数据库工具类
 */

public class DbUtil {

//数据库地址
	private String dbUrl = "jdbc:mysql://localhost:3306/db_book";

//用户名

	private String dbUserName = "root";

//密码	

	private String dbPassword = "123456";

//驱动名称

	private String jdbcName = "com.mysql.jdbc.Driver";

	// 获取数据库连接
	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;

	}

	// 关闭数据库连接
	public void closeCon(Statement smt  ,Connection con) throws Exception {
		if (smt != null) {
			smt.close();
		}
		
		if (con != null) {
			con.close();
		}

	}
	
	
	// 关闭数据库连接
	public void closeCon(Connection con) throws Exception {

		if (con != null) {
			con.close();
		}

	}
	
	

	

	
}

