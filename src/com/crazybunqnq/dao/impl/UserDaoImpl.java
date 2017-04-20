package com.crazybunqnq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crazybunqnq.dao.UserDao;
import com.crazybunqnq.entity.User;

public class UserDaoImpl implements UserDao {

	/*
	 * 保存用户信息。
	 */
	@Override
	public void insertUser(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO user VALUES (id,?,?,0,?,?,?,?,?,?,?)");
		ps.setString(1, user.getName());
		ps.setString(2, user.getPwd());
		ps.setString(3, user.getNickName());
		ps.setString(4, user.getSex());
		ps.setInt(5, user.getAge());
		ps.setInt(6, user.getPhoneNumber());
		ps.setString(7, user.getWeChat());
		ps.setString(8, user.getQQ());
		ps.setDate(9, user.getCreateTime());
		ps.execute();
	}

	/*
	 * 根据用户指定的ID更新用户信息。
	 */
	@Override
	public void update(Connection conn, Long id, User user) throws SQLException {
		String updateSql = "UPDATE tbl_user SET name = ?, pwd = ?, nickname = ?, sex = ?, age = ?, phone = ?, wechat = ?, qq = ?, createtime = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(updateSql);

		ps.setString(1, user.getName());
		ps.setString(2, user.getPwd());
		ps.setString(3, user.getNickName());
		ps.setString(4, user.getSex());
		ps.setInt(5, user.getAge());
		ps.setInt(6, user.getPhoneNumber());
		ps.setString(7, user.getWeChat());
		ps.setString(8, user.getQQ());
		ps.setDate(9, user.getCreateTime());
		ps.execute();
	}

	/*
	 * 删除指定的用户信息。
	 */
	@Override
	public void delete(Connection conn, Long id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM tbl_user WHERE id = ?");
		ps.setLong(1, id);
		ps.execute();
	}


	@Override
	public ResultSet checkUser(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT nickname FROM user WHERE user = ? AND pwd = ?");
		ps.setString(1, user.getName());
		ps.setString(2, user.getPwd());
		return ps.executeQuery();
	}
	
	/**
	 * 查询所有普通用户
	 */
	@Override
	public ResultSet searchUser(Connection conn) throws SQLException {
		return searchManager(conn, 0);
	}
	
	/*
	 * 按照关键词查询用户
	 */
	@Override
	public ResultSet searchUser(Connection conn, String nameKeyWord) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE user LIKE '%" + nameKeyWord + "%' AND limits = 0");
		return ps.executeQuery();
	}

	/**
	 * 按照关键词查询管理员
	 */
	@Override
	public ResultSet searchManager(Connection conn, String nameKeyWord) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT id, user, limits FROM user WHERE limits > 0 AND user LIKE '%" + nameKeyWord + "'");
		return ps.executeQuery();
	}

	/**
	 * 按照权限查询管理员
	 */
	@Override
	public ResultSet searchManager(Connection conn, int limit) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT id, user, limits FROM user WHERE limits = " + limit);
		return ps.executeQuery();
	}
}
