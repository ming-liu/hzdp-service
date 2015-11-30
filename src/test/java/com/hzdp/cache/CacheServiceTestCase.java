package com.hzdp.cache;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hzdp.BaseTestCase;
import com.hzdp.cache.service.CacheService;
import com.hzdp.cache.service.impl.CacheObjectUtil;
import com.hzdp.cache.support.CacheType;
import com.hzdp.cache.support.CacheTypeFactory;
import com.hzdp.crypto.codec.HexString;
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
		brand.setName("活动活动");
		brand.setUrl("http://dsjflsl.ei332.com");
		CacheType smsCacheType = CacheTypeFactory.getCacheType("sms");
		cacheService.put(smsCacheType, "13777777777", brand);
	}
	
	public static void main(String[] args) throws IOException {
		Brand brand = new Brand();
		brand.setCompanyId(12);
		brand.setEnName("hsl");
		brand.setId(3);
		brand.setName("活动活动");
		brand.setUrl("http://dsjflsl.ei332.com");
		String persistObject = CacheObjectUtil.persistObject(brand);
		byte[] converHexStr2Bytes = HexString.converHexStr2Bytes(persistObject);
		String string = new String(converHexStr2Bytes, "UTF-8");
		System.out.println(string);
	}
}
