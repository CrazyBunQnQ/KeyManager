package com.crazybunqnq.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class TransactionTest {
	
	/*
	 * 插入数据
	 * tableName 表名
	 * format 字段格式
	 * values 数据值
	 */
	@Test
	public void insert(Connection conn, String tableName, String format, String values) throws SQLException {
			String sql = "INSERT INTO " + tableName + "(" + format +") VALUES(" + values + ")";
			Statement st = conn.createStatement();
			int count  = st.executeUpdate(sql);
			System.out.println("向用户表插入了 " + count + " 条信息");
	}
}
