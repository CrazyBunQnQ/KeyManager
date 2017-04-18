package com.crazybunqnq.service;

import java.sql.Connection;
import java.sql.ResultSet;

import com.crazybunqnq.dao.UserDao;
import com.crazybunqnq.dao.impl.UserDaoImpl;
import com.crazybunqnq.utils.ConnectionFactory;
import com.google.gson.JsonObject;

public class SearchService {

	public JsonObject searchUser(String keyWord) {
		JsonObject result = new JsonObject();
		UserDao userDao = new UserDaoImpl();
		Connection conn = null;

		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			ResultSet rs = userDao.search(conn, keyWord);
			JsonObject object = new JsonObject();
			int i = 1;
			while (rs.next()) {
				JsonObject element = new JsonObject();
				long aa = rs.getLong("id");
				String bb = rs.getString("name");
				String cc = rs.getString("password");
				String dd = rs.getString("email");
				element.addProperty("id", aa);
				element.addProperty("name", bb);
				element.addProperty("password", cc);
				element.addProperty("email", dd);
				object.add("a" + i, element);
				i++;
			}
			result.add("data", object);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		}
		return null;
	}

	// public boolean check(User user) {
	// Connection conn = null;
	//
	// try {
	// conn = ConnectionFactory.getInstance().makeConnection();
	// conn.setAutoCommit(false);
	//
	// ResultSet resultSet = userDao.get(conn, user);
	//
	// while (resultSet.next()) {
	// return true;
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	//
	// try {
	// conn.rollback();
	// } catch (Exception e2) {
	// e2.printStackTrace();
	// } finally {
	// try {
	// conn.close();
	// } catch (Exception e3) {
	// e3.printStackTrace();
	// }
	// }
	// }
	// return false;
	// }
}