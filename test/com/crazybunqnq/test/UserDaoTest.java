package com.crazybunqnq.test;

import java.sql.Connection;

import com.crazybunqnq.dao.UserDao;
import com.crazybunqnq.dao.impl.UserDaoImpl;
import com.crazybunqnq.entity.User;
import com.crazybunqnq.utils.ConnectionFactory;

public class UserDaoTest {

	private static void insertUser(String name, String password) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			UserDao userDao = new UserDaoImpl();
			User newUser = new User();
			newUser.setName(name);
			newUser.setPwd(password);

			userDao.save(conn, newUser);
			conn.commit();
			System.out.println("======用户信息添加成功======");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("======用户信息添加失败，回滚成功======");
				e.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private static void updateUser(Long id, String name, String password) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			UserDao userDao = new UserDaoImpl();
			User newUser = new User();
			newUser.setName(name);
			newUser.setPwd(password);

			userDao.update(conn, id, newUser);
			conn.commit();
			System.out.println("======用户信息更新成功======");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("======用户信息更新失败，回滚成功======");
				e.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private static void deleteUser(Long id) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			UserDao userDao = new UserDaoImpl();
			User newUser = new User();
			newUser.setId(id);
			userDao.delete(conn, newUser);
			conn.commit();
			System.out.println("======用户删除添加成功======");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("======用户信息删除失败，回滚成功======");
				e.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
//		insertUser("Songya", "250", "250@gmail.com");
//		updateUser(11L, "Liujie", "123456", "liujie@gmail.com");
//		updateUser(11L, "Liujie", "123456", "liujie@gmail.com");
//		deleteUser(11L);
		JDBCTest.main(null);
	}
}
