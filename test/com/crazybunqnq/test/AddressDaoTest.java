package com.crazybunqnq.test;

import java.sql.Connection;

import org.junit.Test;

import com.crazybunqnq.dao.CDKeyDao;
import com.crazybunqnq.dao.impl.CDKeyDaoImpl;
import com.crazybunqnq.entity.CDKey;
import com.crazybunqnq.utils.DBUtil;

public class AddressDaoTest {

	@Test
	public void insertAddress(String city, String country, Long userId) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
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

	@Test
	public void updateAddress(Long id, String city, String country, Long userId) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
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

	@Test
	public void deleteAddress(Long id) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
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
}
