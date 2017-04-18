package com.crazybunqnq.test;

import java.sql.Connection;

import com.crazybun.dao.CDKeyDao;
import com.crazybun.dao.impl.CDKeyDaoImpl;
import com.crazybun.entity.CDKey;
import com.crazybun.jdbc.JDBCTest;
import com.crazybun.util.ConnectionFactory;
import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultElement;

public class AddressDaoTest {

	private static void insertAddress(String city, String country, Long userId) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			CDKeyDao addressDao = new CDKeyDaoImpl();
			CDKey newAddress = new CDKey();
			newAddress.setCDKey(city);
			newAddress.setDeviceID(country);
			newAddress.setUserId(userId);

			addressDao.save(conn, newAddress);
			conn.commit();
			System.out.println("======地址信息添加成功======");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("======地址信息添加失败，回滚成功======");
				e.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private static void updateAddress(Long id, String city, String country, Long userId) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			CDKeyDao addressDao = new CDKeyDaoImpl();
			CDKey newAddress = new CDKey();
			newAddress.setCDKey(city);
			newAddress.setDeviceID(country);
			newAddress.setUserId(userId);

			addressDao.update(conn, id, newAddress);
			conn.commit();
			System.out.println("======地址信息修改成功======");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("======地址信息修改失败，回滚成功======");
				e.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private static void deleteAddress(Long id) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			CDKeyDao addressDao = new CDKeyDaoImpl();
			CDKey deleteId = new CDKey();
			deleteId.setId(id);

			addressDao.delete(conn, deleteId);
			conn.commit();
			System.out.println("======地址信息删除成功======");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("======地址信息删除失败，回滚成功======");
				e.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
//		insertAddress("shandong", "china", 12L);
//		updateAddress(5L, "zhuhai", "china", 12L);
//		deleteAddress(4L);
		JDBCTest.main(null);
	}
}
