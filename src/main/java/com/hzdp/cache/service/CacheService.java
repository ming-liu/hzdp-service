package com.hzdp.cache.service;

import com.hzdp.cache.support.CacheType;

public interface CacheService {

	boolean put(CacheType cacheType, String key, Object object);

	Object get(CacheType cacheType, String key);
}
