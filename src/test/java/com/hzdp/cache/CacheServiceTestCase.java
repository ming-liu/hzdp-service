package com.hzdp.cache;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hzdp.BaseTestCase;
import com.hzdp.cache.service.CacheService;
import com.hzdp.cache.support.CacheType;
import com.hzdp.cache.support.CacheTypeFactory;

public class CacheServiceTestCase extends BaseTestCase {

	@Autowired
	private CacheService cacheService;

	@Test
	public void testCacheService() {
		CacheType smsCacheType = CacheTypeFactory.getCacheType("sms");
		cacheService.put(smsCacheType, "13777777777", "1234");
	}
}
