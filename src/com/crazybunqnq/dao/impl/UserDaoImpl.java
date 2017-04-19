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
	public void save(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareCall("INSERT INTO user VALUES (id,?,?,?,?,?,?,?,?,?)");

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
		PreparedStatement ps = conn.prepareCall(updateSql);

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
	public void delete(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM tbl_user WHERE id = ?");
		ps.setLong(1, user.getId());
		ps.execute();
	}

	/*
	 * 获取用户信息
	 */
	@Override
	public ResultSet get(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_user WHERE name = ? AND password = ?");
		ps.setString(1, user.getName());// 设置第一个参数
		ps.setString(2, user.getPwd());

		return ps.executeQuery();// 返回查询结果
	}

	/*
	 * 查询用户
	 */
	@Override
	public ResultSet search(Connection conn, String unameKeyWord) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_user WHERE name LIKE '%" + unameKeyWord + "%'");
		return ps.executeQuery();
	}
}
