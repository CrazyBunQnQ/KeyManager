package com.crazybunqnq.test;

import java.sql.Connection;

import org.junit.Test;

import com.crazybunqnq.dao.UserDao;
import com.crazybunqnq.dao.impl.UserDaoImpl;
import com.crazybunqnq.entity.User;
import com.crazybunqnq.utils.DBUtil;
import com.crazybunqnq.utils.MD5Util;

public class UserDaoTest {

	@Test
	public void insertUser(String name, String password) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);

			UserDao userDao = new UserDaoImpl();
			User newUser = new User();
			newUser.setName(name);
			newUser.setPwd(MD5Util.getMD5(password));

			userDao.insertUser(conn, newUser);
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

	@Test
	public void updateUser(Long id, String name, String password) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
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

	@Test
	public void deleteUser(Long id) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);

			UserDao userDao = new UserDaoImpl();
			User newUser = new User();
//			newUser.setId(id);
//			userDao.delete(conn, newUser);
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
}
