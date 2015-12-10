package com.hzdp.sms.impl;

import org.springframework.stereotype.Service;

import com.hzdp.sms.SmsService;
import com.hzdp.sms.bean.SmsResult;

@Service
public class SmsServiceImpl implements SmsService {

	@Override
	public SmsResult sendVerifyCode(String mobile, String remoteAddr) {
		SmsResult smsResult = new SmsResult();
		return smsResult;
	}

}
