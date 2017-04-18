package com.crazybunqnq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crazybun.dao.UserDao;
import com.crazybun.entity.User;

public class UserDaoImpl implements UserDao {

	/*
	 * 保存用户信息。
	 */
	@Override
	public void save(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareCall("INSERT INTO tbl_user(name, password, permission, email, qq) VALUES (?,?,?,?,?)");

		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setInt(3, user.getPermission());
		ps.setString(4, user.getEmail());
		ps.setString(5, user.getQQ());
		ps.execute();
	}

	/*
	 * 根据用户指定的ID更新用户信息。
	 */
	@Override
	public void update(Connection conn, Long id, User user) throws SQLException {
		String updateSql = "UPDATE tbl_user SET name = ?, password = ?, permission = ?, email = ?, qq = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareCall(updateSql);

		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setInt(3, user.getPermission());
		ps.setString(4, user.getEmail());
		ps.setString(5, user.getQQ());
		ps.setLong(6, id);
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
		ps.setString(2, user.getPassword());

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
