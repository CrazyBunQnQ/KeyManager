package com.crazybunqnq.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class JDBCTest {

	@Test
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db", "root", "toor");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/*
	 * 插入数据 tableName 表名 format 字段格式 values 数据值
	 */
	@Test
	public void insert(String tableName, String format, String values) {
		Connection conn = getConnection();
		try {
			String sql = "INSERT INTO " + tableName + "(" + format + ") VALUES(" + values + ")";
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("向用户表插入了 " + count + " 条信息");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 更新数据 tableName 表名 newValue 新值 exp 条件表达式
	 */
	@Test
	public void update(String tableName, String newValue, String exp) {
		Connection conn = getConnection();
		try {
			String sql = "UPDATE " + tableName + " SET " + newValue + " " + exp;
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("向用户表更新了 " + count + " 条信息");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 删除数据 tableName 表名 exp 条件表达式
	 */
	@Test
	public void delete(String tableName, String exp) {
		Connection conn = getConnection();
		try {
			String sql = "DELETE FROM " + tableName + " WHERE " + exp;
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("从用户表删除了 " + count + " 条信息");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 查询用户表
	 */
	@Test
	public void queryUsers() {
		String sql = "SELECT * FROM tbl_user";
		Connection conn = getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.print(rs.getInt("id") + "  ");
				System.out.print(rs.getString("name") + "  ");
				System.out.print(rs.getString("password") + "  ");
				System.out.print(rs.getString("email") + "  ");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e2) {
			}

			try {
				st.close();
			} catch (Exception e2) {
			}

			try {
				conn.close();
			} catch (Exception e2) {
			}
		}
	}

	/*
	 * 查询地址表
	 */
	@Test
	public void queryAddress() {
		String sql = "SELECT * FROM tbl_cdkey";
		Connection conn = getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.print(rs.getInt("id") + "  ");
				System.out.print(rs.getString("city") + "  ");
				System.out.print(rs.getString("country") + "  ");
				System.out.print(rs.getString("user_id") + "  ");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e2) {
			}

			try {
				st.close();
			} catch (Exception e2) {
			}

			try {
				conn.close();
			} catch (Exception e2) {
			}
		}
	}
}
