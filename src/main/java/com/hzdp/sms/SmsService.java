package com.hzdp.sms;

import com.hzdp.sms.bean.SmsSendResponse;
import com.hzdp.sms.bean.SmsVerifyResponse;

public interface SmsService {

	SmsSendResponse sendVerifyCode(String mobile,String remoteAddr);
	
	SmsVerifyResponse verify(String mobile,String remoteAddr,String code);
}
