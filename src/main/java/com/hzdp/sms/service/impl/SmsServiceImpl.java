package com.hzdp.sms.service.impl;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzdp.sms.SmsConstants;
import com.hzdp.sms.bean.SmsSendResponse;
import com.hzdp.sms.bean.SmsVerifyResponse;
import com.hzdp.sms.dao.SmsDao;
import com.hzdp.sms.entity.Sms;
import com.hzdp.sms.service.SmsService;
import com.hzdp.util.IPUtil;

@Service
public class SmsServiceImpl implements SmsService {

	protected Logger logger = Logger.getLogger(getClass());

	public static final int TooMuchTimesIn1Min = 2;
	public static final int TooMuchTimesIn1MinPerIP = 10;
	public static final int TIMEOUT = 120;

	@Autowired
	private SmsDao smsDao;

	@Override
	public SmsSendResponse sendVerifyCode(String mobile, String ip) {
		SmsSendResponse response = new SmsSendResponse();
		try {
			List<Sms> smsList = smsDao.findByMobile(mobile);
			if (tooMuchCheck(TooMuchTimesIn1Min, smsList)) {
				response.setType(SmsSendResponse.TOO_MUCH);
				return response;
			}

			smsList = smsDao.findByIp(ip);
			if (tooMuchCheck(TooMuchTimesIn1MinPerIP, smsList)) {
				response.setType(SmsSendResponse.TOO_MUCH);
				return response;
			}

			long ipValue = IPUtil.toInt(ip);

			Sms po = new Sms();
			po.setAddTime(new Date());
			po.setContent(RandomStringUtils.randomNumeric(4));
			po.setContentType(SmsConstants.ContentTypeVerify);
			po.setIp(ipValue);
			po.setMobile(mobile);
			po.setStatus(SmsConstants.StatusCreate);
			po.setUpdateTime(po.getAddTime());
			smsDao.insert(po);
		} catch (SQLException e) {
			logger.error("sendVerifyCode error", e);
		}
		return response;
	}

	private boolean tooMuchCheck(int tooMuchLine, List<Sms> smsList) {
		if (!smsList.isEmpty()) {
			Calendar instance = Calendar.getInstance();
			instance.add(Calendar.SECOND, -60);
			int count = 0;
			for (Sms sms : smsList) {
				if (sms.getAddTime().getTime() >= instance.getTimeInMillis()) {
					count++;
				}
			}
			if (count >= tooMuchLine - 1) {
				return true;
			}
		}

		return false;
	}

	@Override
	public SmsVerifyResponse verify(String mobile, String remoteAddr, String code) {
		long currentTimeMillis = System.currentTimeMillis();
		SmsVerifyResponse response = new SmsVerifyResponse();
		try {
			List<Sms> smsList = smsDao.findByMobile(mobile);
			for (Sms sms : smsList) {
				if (sms.getContent().equals(code) && IPUtil.toString(sms.getIp()).equals(remoteAddr)) {
					long interval = (currentTimeMillis - sms.getAddTime().getTime()) / 1000;
					if(interval <= TIMEOUT){
						response.setType(SmsVerifyResponse.SUCCESS);
					} else {
						response.setType(SmsVerifyResponse.TIMEOUT);
					}
					break;
				}
			}
		} catch (SQLException e) {
			logger.error("verify error", e);
		}

		return response;
	}

}
