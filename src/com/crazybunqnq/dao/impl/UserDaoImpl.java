package com.crazybunqnq.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crazybunqnq.dao.UserDao;
import com.crazybunqnq.entity.User;

public class UserDaoImpl implements UserDao {

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
		Date createTime;
		ps.setDate(9, new Date(user.getCreateTime().getTime()));
		ps.execute();
	}

	@Override
	public boolean delete(Connection conn, Long id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM tbl_user WHERE id = ?");
		ps.setLong(1, id);
		return ps.execute();
	}

	@Override
	public boolean update(Connection conn, Long id, User user) throws SQLException {
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
		ps.setDate(9, new Date(user.getCreateTime().getTime()));
		return ps.execute();
	}

	@Override
	public ResultSet checkUser(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT user FROM user WHERE user = ? AND pwd = ?");
		ps.setString(1, user.getName());
		ps.setString(2, user.getPwd());
		return ps.executeQuery();
	}

	@Override
	public ResultSet hasUser(Connection conn, String name) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT user FROM user WHERE user = ?");
		ps.setString(1, name);
		return ps.executeQuery();
	}

	@Override
	public ResultSet searchUser(Connection conn) throws SQLException {
		return searchManager(conn, 0);
	}

	@Override
	public ResultSet searchUser(Connection conn, String name, boolean isNick) throws SQLException {
		PreparedStatement ps = null;
		if (isNick) {
			ps = conn.prepareStatement("SELECT * FROM user WHERE nickname LIKE '%" + name + "%' AND limits = 0");
		} else {
			ps = conn.prepareStatement("SELECT * FROM user WHERE user LIKE '%" + name + "%' AND limits = 0");
		}
		return ps.executeQuery();
	}

	@Override
	public ResultSet searchManager(Connection conn, String name, boolean isNick) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(
				"SELECT id, user, nickname, limits, createtime FROM user WHERE limits > 0 AND nickname LIKE '%" + name + "'");
		return ps.executeQuery();
	}

	@Override
	public ResultSet searchManager(Connection conn, int limit) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT id, user, nickname, limits, createtime FROM user WHERE limits = " + limit);
		return ps.executeQuery();
	}
}
