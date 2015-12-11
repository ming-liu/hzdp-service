package com.hzdp.sms.bean;

public class SmsVerifyResponse {

	public static final int SUCCESS = 1;
	public static final int IP_CHANGED = 2;
	public static final int TIMEOUT = 3;

	public static final int FAIL = 4;

	private int type = FAIL;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
