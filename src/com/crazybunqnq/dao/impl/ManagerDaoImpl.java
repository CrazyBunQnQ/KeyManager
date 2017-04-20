package com.crazybunqnq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.crazybunqnq.dao.ManagerDao;
import com.crazybunqnq.entity.Manager;

public class ManagerDaoImpl implements ManagerDao {

	@Override
	public void delete(Connection conn, Manager manager) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public ResultSet search(Connection conn) throws SQLException {
		Statement st = conn.createStatement();
		String sql = "select id '编号', manager '管理员', limits '权限' from manager";
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}

	@Override
	public ResultSet search(Connection conn, Manager manager) throws SQLException {
		PreparedStatement ps = conn.prepareCall(
				"SELECT id '编号', manager '管理员', limits '权限' FROM manager WHERE manager = ? AND limits = ?");
		ps.setString(1, manager.getName());
		ps.setInt(2, manager.getLimits());
		return ps.executeQuery();
	}

	@Override
	public ResultSet search(Connection conn, String nameKeyWord) throws SQLException {
		PreparedStatement ps = conn
				.prepareCall("SELECT id '编号', manager '管理员', limits '权限' FROM manager WHERE manager LIKE '%?%'");
		ps.setString(1, nameKeyWord);
		return ps.executeQuery();
	}

	@Override
	public ResultSet search(Connection conn, int limit) throws SQLException {
		PreparedStatement ps = conn.prepareCall("SELECT id, manager, limits FROM manager WHERE limits = ?");
		ps.setInt(1, limit);
		return ps.executeQuery();
	}
}
