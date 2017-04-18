package com.crazybunqnq.utils;

import java.sql.Connection;
import java.util.Calendar;

import com.crazybun.dao.CDKeyDao;
import com.crazybun.dao.impl.CDKeyDaoImpl;
import com.crazybun.entity.CDKey;

public class CDKeyBuilder {

	public static void massProduction(int count, String days) {
		for (int i = 0; i < count; i++) {
			createOne(days);
		}
	}

	private static void createOne(String days) {
		Calendar now = Calendar.getInstance();
		String timeStamp = String.valueOf(now.getTimeInMillis()).substring(4);
		// 2009-9-9 23:22:11
		/*
		 * String timeStr = now.get(Calendar.YEAR) + "-" +
		 * now.get(Calendar.MONTH) + "-" + now.get(Calendar.DAY_OF_MONTH) + " "
		 * + now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE) +
		 * ":" + now.get(Calendar.SECOND);
		 */
		// System.out.println(timeStamp);
		timeStamp = keyEncryption(timeStamp, 1);
		StringBuilder sb = new StringBuilder(timeStamp);
		String dayStr = keyEncryption(days.length() > 1 ? days : 0 + days, 2);
		String rand = keyEncryption(((int) (Math.random() * (9999 - 1000 + 1)) + 1000) + "", 3);
		sb.insert(7, rand);
		sb.insert(3, dayStr);
		String cdkyeStr = sb.toString();
		// System.out.println(timeStamp);
		// System.out.println(dayStr);
		// System.out.println(rand);
		// System.out.println(cdkyeStr);
		insertCDKey(cdkyeStr, Integer.valueOf(days));
	}

	private static void insertCDKey(String cdkey, int days) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			CDKeyDao cdkeyDao = new CDKeyDaoImpl();
			CDKey newCDKey = new CDKey();
			newCDKey.setCDKey(cdkey);
			newCDKey.setDays(days);

			cdkeyDao.save(conn, newCDKey);
			conn.commit();
			System.out.println("======CDKey信息添加成功======");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("======CDKey信息添加失败，回滚成功======");
				e.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private static void updateCDKey(Long id, String device, Long userId) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			CDKeyDao addressDao = new CDKeyDaoImpl();
			CDKey newAddress = new CDKey();
			newAddress.setDeviceID(device);
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

	private static String keyEncryption(String time, int type) {
		char[] array = time.toCharArray();
		switch (type) {
		case 1:
			for (int i = 0; i < array.length; i++) {
				array[i] = (char) (array[i] + 17);
			}
			break;
		case 2:
			for (int i = 0; i < array.length; i++) {
				array[i] = (char) (array[i] + 27);
			}
			break;
		default:
			for (int i = 0; i < array.length; i++) {
				array[i] = (char) (array[i] + 33);
			}
			break;
		}
		return new String(array);
	}
}
