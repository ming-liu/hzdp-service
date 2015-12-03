package com.hzdp.cache;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hzdp.BaseTestCase;
import com.hzdp.cache.service.CacheService;
import com.hzdp.cache.support.CacheType;
import com.hzdp.cache.support.CacheTypeFactory;
import com.hzdp.entity.Brand;

public class CacheServiceTestCase extends BaseTestCase {

	@Autowired
	private CacheService cacheService;

	@Test
	public void testCacheService() {
		Brand brand = new Brand();
		brand.setCompanyId(12);
		brand.setEnName("hsl");
		brand.setId(3);
		brand.setName("12活动活动33d");
		brand.setUrl("http://dsjflsl.ei332.com");
		CacheType smsCacheType = CacheTypeFactory.getCacheType("sms");
		cacheService.put(smsCacheType, "13777777777", brand);
	}

	@Test
	public void testGet() {
		Brand brand = new Brand();
		brand.setCompanyId(12);
		brand.setEnName("hsl");
		brand.setId(3);
		brand.setName("12活动活动33d");
		brand.setUrl("http://dsjflsl.ei332.com");
		CacheType smsCacheType = CacheTypeFactory.getCacheType("sms");
		Object object = cacheService.get(smsCacheType, "13777777777");
		System.out.println(object);
	}

}
