package com.hzdp.cache.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hzdp.cache.support.CacheEntity;
import com.hzdp.dao.BaseDao;

@Service
public class CacheDao extends BaseDao {

	public boolean insert(CacheEntity entity) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("po", entity);
		insert("Cache.insert", params);
		return true;
	}

	public CacheEntity findByKey(String key) throws SQLException {
		return (CacheEntity) queryObject("Cache.findByKey", key);
	}
}
