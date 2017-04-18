package com.crazybunqnq.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.crazybun.entity.CDKey;

public interface CDKeyDao {

	public void save(Connection conn, CDKey cdkey) throws SQLException;

	public void update(Connection conn, Long id, CDKey cdkey) throws SQLException;

	public void delete(Connection conn, CDKey cdkey) throws SQLException;
}
