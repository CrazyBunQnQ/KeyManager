package com.crazybunqnq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.crazybunqnq.dao.CDKeyDao;
import com.crazybunqnq.entity.CDKey;

public class CDKeyDaoImpl implements CDKeyDao {

	/*
	 * 保存地址信息。
	 */
	@Override
	public void save(Connection conn, CDKey cdkey) throws SQLException {
		PreparedStatement ps = conn.prepareCall("INSERT INTO tbl_cdkey(cdkey, days) VALUES (?,?)");
		ps.setString(1, cdkey.getCDKey());
		ps.setLong(2, cdkey.getDays());
		ps.execute();
	}

	/*
	 * 根据指定ID更新地址信息
	 */
	@Override
	public void update(Connection conn, Long id, CDKey cdkey) throws SQLException {
		String updateSql = "UPDATE tbl_cdkey SET device = ?, user_id = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareCall(updateSql);

		ps.setString(1, cdkey.getDeviceID());
		ps.setLong(2, cdkey.getUserId());
		ps.setLong(3, id);
		ps.execute();
	}

	/*
	 * 删除指定的地址信息
	 */
	@Override
	public void delete(Connection conn, CDKey cdkey) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM tbl_cdkey WHERE id = ?");
		ps.setLong(1, cdkey.getId());
		ps.execute();
	}
}
