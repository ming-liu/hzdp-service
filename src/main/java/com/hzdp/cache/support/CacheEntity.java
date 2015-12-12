package com.hzdp.cache.support;

import java.util.Date;

public class CacheEntity {

	private int id;
	private int cacheType;
	private String key;
	private String value;
	private int expirePeriod;
	private Date addTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCacheType() {
		return cacheType;
	}

	public void setCacheType(int cacheType) {
		this.cacheType = cacheType;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getExpirePeriod() {
		return expirePeriod;
	}

	public void setExpirePeriod(int expirePeriod) {
		this.expirePeriod = expirePeriod;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
}
