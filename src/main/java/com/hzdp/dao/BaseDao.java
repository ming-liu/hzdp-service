package com.hzdp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import com.ibatis.sqlmap.client.SqlMapClient;

public class BaseDao {

	@Resource(name = "hzdp.sqlMapClient")
	private SqlMapClient sqlMapClient;

	public Object queryObject(String id, Object parameterObject) throws SQLException {
		return sqlMapClient.queryForObject(id, parameterObject);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> queryList(String id, Object parameterObject) throws SQLException {
		return sqlMapClient.queryForList(id, parameterObject);
	}

	public int update(String id, Object parameterObject) throws SQLException {
		return sqlMapClient.update(id, parameterObject);
	}

	public Object insert(String id, Object parameterObject) throws SQLException {
		return sqlMapClient.insert(id, parameterObject);
	}
}
