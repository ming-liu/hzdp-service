package com.hzdp.cache.support.simple;

import com.hzdp.cache.support.CacheType;

public class DefaultCacheType implements CacheType {

	private int expirePeriod;
	private int type;

	@Override
	public int expirePeriod() {
		return expirePeriod;
	}

	@Override
	public int type() {
		return type;
	}

	public void setExpirePeriod(int expirePeriod) {
		this.expirePeriod = expirePeriod;
	}

	public void setType(int type) {
		this.type = type;
	}

}
