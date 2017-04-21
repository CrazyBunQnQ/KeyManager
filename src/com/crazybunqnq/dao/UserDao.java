package com.crazybunqnq.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crazybunqnq.entity.User;

public interface UserDao {

	/**
	 * 增加一条用户记录
	 * @param conn
	 * @param user
	 * @throws SQLException
	 */
	public void insertUser(Connection conn, User user) throws SQLException;

	/**
	 * 根据 id 删除一条用户记录
	 * @param conn
	 * @param id
	 * @throws SQLException
	 */
	public boolean delete(Connection conn, Long id) throws SQLException;

	/**
	 * 根据 id 修改指定用户信息
	 * @param conn
	 * @param id
	 * @param user
	 * @throws SQLException
	 */
	public boolean update(Connection conn, Long id, User user) throws SQLException;
	
	/**
	 * 检查用户名密码是否匹配
	 * @param conn
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public ResultSet checkUser(Connection conn, User user) throws SQLException;
	
	/**
	 * 查找指定用户
	 * @param conn
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public ResultSet hasUser(Connection conn, String name) throws SQLException;
	
	/**
	 * 查找所有普通用户
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public ResultSet searchUser(Connection conn) throws SQLException;
	
	/**
	 * 根据用户名或昵称模糊查找用户
	 * @param conn
	 * @param name 用户名或昵称
	 * @param isNick 是否按照昵称查找
	 * @return
	 * @throws SQLException
	 */
	public ResultSet searchUser(Connection conn, String name, boolean isNick) throws SQLException;
	
	/**
	 * 根据用户名模糊查找管理员
	 * @param conn
	 * @param name 管理员用户名或昵称
	 * @param isNick 是否按照昵称查询
	 * @return
	 * @throws SQLException
	 */
	public ResultSet searchManager(Connection conn, String name, boolean isNick) throws SQLException;
	
	/**
	 * 根据权限查找管理员
	 * @param conn
	 * @param limit
	 * @return
	 * @throws SQLException
	 */
	public ResultSet searchManager(Connection conn, int limit) throws SQLException;
}
