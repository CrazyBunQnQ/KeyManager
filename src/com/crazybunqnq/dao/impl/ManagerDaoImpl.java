package com.crazybunqnq.dao.impl;

import java.sql.Connection;
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
		
		return null;
	}

	@Override
	public ResultSet search(Connection conn, String nameKeyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
