package com.hzdp.service.impl;

import org.springframework.stereotype.Service;

import com.hzdp.service.SmsService;

@Service
public class SmsServiceImpl implements SmsService {

	@Override
	public String sendVerifyCode(String mobile) {
		return "1234";
	}

}
