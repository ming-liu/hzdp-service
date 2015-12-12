package com.hzdp.cache.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzdp.cache.dao.CacheDao;
import com.hzdp.cache.service.CacheService;
import com.hzdp.cache.support.CacheEntity;
import com.hzdp.cache.support.CacheType;
import com.hzdp.crypto.codec.MD5;
import com.hzdp.serialize.Serializer;
import com.hzdp.serialize.SerializerFactory;

@Service
public class DefaultCacheImpl implements CacheService {

	@Autowired
	private CacheDao cacheDao;

	private Serializer serializer = SerializerFactory.get(SerializerFactory.JSON_SERIALIZER);

	@Override
	public boolean put(CacheType cacheType, String key, Object object) {
		try {
			String mdKey = MD5.digest(key);
			String value = serializer.serialize(object);
			CacheEntity cacheEntity = new CacheEntity();
			cacheEntity.setCacheType(cacheType.type());
			cacheEntity.setExpirePeriod(cacheType.expirePeriod());
			cacheEntity.setAddTime(new Date());
			cacheEntity.setKey(mdKey);
			cacheEntity.setValue(value);
			cacheDao.insert(cacheEntity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Object get(CacheType cacheType, String key) {
		try {
			String mdKey = MD5.digest(key);
			CacheEntity cacheEntity = cacheDao.findByKey(mdKey);
			long availableTime = cacheEntity.getAddTime().getTime() + cacheEntity.getExpirePeriod();
			if (availableTime <= System.currentTimeMillis()) {
				String value = cacheEntity.getValue();
				return serializer.deserialize(value);
			}
		} catch (Exception e) {
		}
		return null;
	}

}
