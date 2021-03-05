package com.bit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class LoginDao {
	javax.sql.DataSource dataSource;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public LoginDao() {
		try {
			//		InitialContext initCon=new InitialContext();
			//		javax.naming.Context context=null;
			//		context=(Context) initCon.lookup("java:/comp/env");
			//		
			//		dataSource=(DataSource) context.lookup("jdbc/maria");
			//위에꺼 아래꺼 둘다 사용가능	
			InitialContext initCon=new InitialContext();
			dataSource=(DataSource) initCon.lookup("java:/comp/env/jdbc/maria");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void 

}
