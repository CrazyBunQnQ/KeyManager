package com.crazybunqnq.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crazybunqnq.dao.UserDao;
import com.crazybunqnq.dao.impl.UserDaoImpl;
import com.crazybunqnq.entity.User;
import com.crazybunqnq.utils.DBUtil;

public class UserService {

	private UserDao userDao = new UserDaoImpl();

	public boolean checkPwd(User user) {
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			rs = userDao.checkUser(conn, user);
			if (rs.next()) {
				DBUtil.closeConnection(conn, null, rs);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				try {
					DBUtil.closeConnection(conn, null, rs);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public boolean hasUser(String name) {
		Connection conn = null;
		ResultSet rs=null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			rs = userDao.hasUser(conn, name);
			if (rs.next()) {
				DBUtil.closeConnection(conn, null, rs);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeConnection(conn, null, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public void addUser(User user) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			userDao.insertUser(conn, user);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				DBUtil.closeConnection(conn, null, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
