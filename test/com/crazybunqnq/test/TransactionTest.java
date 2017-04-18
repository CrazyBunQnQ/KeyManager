package com.crazybunqnq.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionTest {
	
	/*
	 * 插入数据
	 * tableName 表名
	 * format 字段格式
	 * values 数据值
	 */
	public static void insert(Connection conn, String tableName, String format, String values) throws SQLException {
			String sql = "INSERT INTO " + tableName + "(" + format +") VALUES(" + values + ")";
			Statement st = conn.createStatement();
			int count  = st.executeUpdate(sql);
			System.out.println("向用户表插入了 " + count + " 条信息");
	}
	
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = JDBCTest.getConnection();
			conn.setAutoCommit(false);//禁止自动提交
			insert(conn, "tbl_user", "id, name, password, email", "10, 'Tom', '123456', 'tom@gmail.com'");
			insert(conn, "tbl_address", "id, city, country, user_id", "1, 'shanghai', 'china', '10'");
			conn.commit();
			System.out.println("=========数据添加成功========");
		} catch (SQLException e) {
			System.out.println("=========捕获到SQL异常========");
			e.printStackTrace();
			
			try {
				conn.rollback();
				System.out.println("========事务回滚成功======");
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
			
		}
	}
}
