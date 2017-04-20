package com.crazybunqnq.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crazybunqnq.entity.User;

public interface UserDao {

	public void insertUser(Connection conn, User user) throws SQLException;

	public void delete(Connection conn, Long id) throws SQLException;

	public void update(Connection conn, Long id, User user) throws SQLException;
	
	public ResultSet checkUser(Connection conn, User user) throws SQLException;
	
	public ResultSet searchUser(Connection conn) throws SQLException;
	
	public ResultSet searchUser(Connection conn, String nameKeyWord) throws SQLException;
	
	public ResultSet searchManager(Connection conn, String nameKeyWord) throws SQLException;
	
	public ResultSet searchManager(Connection conn, int limit) throws SQLException;
}
