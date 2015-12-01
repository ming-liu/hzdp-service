package com.hzdp.cache.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

import com.hzdp.cache.service.CacheService;
import com.hzdp.cache.support.CacheType;
import com.hzdp.crypto.codec.HexString;

@Service
public class DefaultCacheImpl implements CacheService {

	public static final String MD5 = "MD5";

	@Override
	public boolean put(CacheType cacheType, String key, Object object) {
		try {
			MessageDigest md = MessageDigest.getInstance(MD5);
			byte[] digest = md.digest(key.getBytes("UTF-8"));
			String mdKey = HexString.convertByte2Hex(digest);
			int expirePeriod = cacheType.expirePeriod();
			int type = cacheType.type();
			String persistObject = CacheObjectUtil.persistObject(object);
			System.out.println(persistObject);
			Object parseObject = CacheObjectUtil.parseObject(persistObject);
			System.out.println(parseObject);
			String serialize = JsonSerializer.serialize(object);
			System.out.println(serialize);
		} catch (NoSuchAlgorithmException e) {
		} catch (UnsupportedEncodingException e) {
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}
		return false;
	}

	@Override
	public Object get(CacheType cacheType, String key) {
		return null;
	}

}
