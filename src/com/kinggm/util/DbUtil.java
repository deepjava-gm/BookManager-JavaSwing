package com.kinggm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * ���ݿ⹤����
 */

public class DbUtil {

//���ݿ��ַ
	private String dbUrl = "jdbc:mysql://localhost:3306/db_book";

//�û���

	private String dbUserName = "root";

//����	

	private String dbPassword = "123456";

//��������

	private String jdbcName = "com.mysql.jdbc.Driver";

	// ��ȡ���ݿ�����
	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;

	}

	// �ر����ݿ�����
	public void closeCon(Statement smt  ,Connection con) throws Exception {
		if (smt != null) {
			smt.close();
		}
		
		if (con != null) {
			con.close();
		}

	}
	
	
	// �ر����ݿ�����
	public void closeCon(Connection con) throws Exception {

		if (con != null) {
			con.close();
		}

	}
	
	

	

	
}

