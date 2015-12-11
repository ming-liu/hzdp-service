package com.hzdp.sms;

public class SmsTemplate {

	public static String getContent(int contentType,String[] params) {
		switch (contentType) {
		case SmsConstants.ContentTypeVerify:
			return "您正在使用{m}注册***,您的验证码是{c}";
		default:
			break;
		}
		return null;
	}
}
