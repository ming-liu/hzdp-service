package com.hzdp.sms;

import com.hzdp.sms.bean.SmsResult;

public interface SmsService {

	SmsResult sendVerifyCode(String mobile,String remoteAddr);
}
