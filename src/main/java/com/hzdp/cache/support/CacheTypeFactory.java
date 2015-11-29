package com.hzdp.cache.support;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheTypeFactory {

	private static CacheTypeFactory instance = null;

	@Autowired
	@Resource(name="cacheTypes")
	private Map<String, CacheType> cacheTypes;

	@PostConstruct
	public void cacheInstaince() {
		instance = this;
	}

	public static CacheType getCacheType(String cacheType) {
		return instance.cacheTypes.get(cacheType);
	}
}
