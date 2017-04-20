package com.crazybunqnq.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crazybunqnq.entity.Manager;

public interface ManagerDao {
	public void delete(Connection conn, Manager manager) throws SQLException;

	public ResultSet search(Connection conn) throws SQLException;

	public ResultSet search(Connection conn, Manager manager) throws SQLException;

	public ResultSet search(Connection conn, String nameKeyWord) throws SQLException;
}
