package com.crazybunqnq.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.crazybunqnq.utils.DBUtil;

public class DBTest {
	@Test
	public void connectionMySQL() {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			System.out.println("连接成功");
			DBUtil.closeConnection(conn);
			System.out.println("关闭连接");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
