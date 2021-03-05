package com.bit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDb {
	private static Connection conn;
	private static String driver="org.mariadb.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/xe";
	private static String user="scott";
	private static String password="tiger";
	
	private MariaDb() {}
	
	public static Connection getConnection() {
		try {
			if(conn==null) {
				Class.forName(driver);
				conn=DriverManager.getConnection(url, user, password);
			}else if(conn.isClosed()) {
				Class.forName(driver);
				conn=DriverManager.getConnection(url, user, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
