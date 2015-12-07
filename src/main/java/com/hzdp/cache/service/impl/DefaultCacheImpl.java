package com.hzdp.cache.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzdp.cache.dao.CacheDao;
import com.hzdp.cache.service.CacheService;
import com.hzdp.cache.support.CacheEntity;
import com.hzdp.cache.support.CacheType;
import com.hzdp.crypto.codec.HexString;
import com.hzdp.serialize.Serializer;
import com.hzdp.serialize.SerializerFactory;

@Service
public class DefaultCacheImpl implements CacheService {

	public static final String MD5 = "MD5";

	@Autowired
	private CacheDao cacheDao;

	private Serializer serializer = SerializerFactory.get(SerializerFactory.JSON_SERIALIZER);

	@Override
	public boolean put(CacheType cacheType, String key, Object object) {
		try {
			String mdKey = parse2MDKey(key);
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

	private String parse2MDKey(String key) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance(MD5);
		byte[] digest = md.digest(key.getBytes("UTF-8"));
		String mdKey = HexString.convertByte2Hex(digest);
		return mdKey;
	}

	@Override
	public Object get(CacheType cacheType, String key) {
		try {
			String mdKey = parse2MDKey(key);
			CacheEntity cacheEntity = cacheDao.findByKey(mdKey);
			String value = cacheEntity.getValue();
			return serializer.deserialize(value);
		} catch (Exception e) {
		}
		return null;
	}

}
