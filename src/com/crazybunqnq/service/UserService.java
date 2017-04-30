package com.crazybunqnq.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.crazybunqnq.dao.UserDao;
import com.crazybunqnq.dao.impl.UserDaoImpl;
import com.crazybunqnq.entity.User;
import com.crazybunqnq.utils.DBUtil;

public class UserService {

	private UserDao userDao = new UserDaoImpl();

	public boolean checkPwd(User user) {
		Connection conn = null;
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
	
	public List<User> searchUser(String name, boolean isNick) {
		Connection conn = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<User>();
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			rs = userDao.searchUser(conn, name == null? "": name, isNick);
			while (rs.next()) {
				Long id = rs.getLong(1);
				String userName = rs.getString(2);
				String nickNime = rs.getString(5);
				Date createTime = rs.getDate(11);
				User user = new User(id, userName, "", 0, nickNime, "", 0, "", "", "", createTime);
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public List<User> searchManager(String name, boolean isNick){
		Connection conn = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<User>();
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			rs = userDao.searchManager(conn, name == null? "": name, isNick);
			while (rs.next()) {
				Long id = rs.getLong(1);
				String userName = rs.getString(2);
				String nickNime = rs.getString(3);
				Integer limit = rs.getInt(4);
				Date createTime = rs.getDate(5);
				User user = new User(id, userName, "", limit, nickNime, "", 0, "", "", "", createTime);
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				DBUtil.closeConnection(conn, null, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}
}
