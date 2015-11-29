package com.hzdp.cache.support;

public interface CacheType {

	/**
	 * expired in second
	 * 
	 * @return
	 */
	int expirePeriod();

	int type();
}
