package com.hzdp.sms.bean;

public class SmsResult {

	public static final int SUCCESS = 1;
	public static final int TOO_MUCH = 2;
	public static final int WRONG_MOBILE = 3;
	public static final int FAIL = 4;

	private int type = FAIL;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
