package com.crazybunqnq.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 连接数据库工具
 * @author Administrator
 *
 */
public class DBUtil {
	private static String dbDriver;
	private static String dbURL;
	private static String dbUser;
	private static String dbPwd;
	
	/**
	 * 加载驱动，只加载一次
	 */
	static{
		/**
		 * 解析配置文件
		 * 1.创建对象
		 * 2.调用load加载本地文件
		 * 调用getProperty(key),根据key
		 */
		Properties pr = new Properties();
		try {
			pr.load(DBUtil.class.getClassLoader().getResourceAsStream("dbconfig.properties"));
			dbDriver = pr.getProperty("driver");
			dbURL = pr.getProperty("url");
			dbUser = pr.getProperty("user");
			dbPwd = pr.getProperty("pwd");
			Class.forName(dbDriver);
			System.out.println("=======配置文件读取成功=======");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("=======配置文件读取错误：流=======");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("=======配置文件读取错误：未找到类=======");
		}
	}
	
	/**
	 * 获取数据库连接的方法
	 * @return 连接对象
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(dbURL,dbUser,dbPwd);
		return conn;
	}
	
	/**
	 * 关闭数据库连接
	 * @param conn
	 * @throws SQLException
	 */
	public static void closeConnection(Connection conn, Statement st, ResultSet res) throws SQLException {
		if (st != null) {
			st.close();
		}
		if (res != null) {
			res.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
}
