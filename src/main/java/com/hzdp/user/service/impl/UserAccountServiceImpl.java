package com.hzdp.user.service.impl;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzdp.crypto.TokenUtil;
import com.hzdp.crypto.codec.SHA1;
import com.hzdp.entity.UserAccount;
import com.hzdp.user.dao.UserAccountDao;
import com.hzdp.user.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	private static final String Salt = "3332ffayleyiid93JDKKue32";

	protected Logger logger = Logger.getLogger(getClass());

	@Autowired
	private UserAccountDao userAccountDao;

	@Override
	public UserAccount findByMobile(String mobile) {
		UserAccount userAccount = null;
		try {
			userAccount = userAccountDao.findByMobile(mobile);
		} catch (SQLException e) {
			logger.error("findByMobile error", e);
		}
		return userAccount;
	}

	@Override
	public int create(UserAccount userAccount) {
		if (userAccount.getAddTime() == null) {
			userAccount.setAddTime(new Date());
		}
		if (userAccount.getName() == null) {
			userAccount.setName("");
		}
		String password = userAccount.getPassword();
		String mix = mix(password);
		String salt = RandomStringUtils.randomAlphanumeric(16);

		String peristSalt = TokenUtil.generateToken(salt);
		userAccount.setPassword(SHA1.digest(mix + salt));
		userAccount.setSalt(peristSalt);

		try {
			return userAccountDao.save(userAccount);
		} catch (SQLException e) {
			logger.error("save userAccount error", e);
		}
		return 0;
	}

	private String mix(String password) {
		String s0 = password.substring(0, 3);
		String s1 = password.substring(3);
		int rout = s1.length() % 3;
		if (rout == 0) {
			s0 = s0 + "s3$Wf3d2FF3105";
			s1 = "kllg22gddKIe3_3" + s1;
		} else if (rout == 1) {
			s0 = "lo7wL3MINan4" + s1 + s0;
			s1 = s1 + "fl##yl21" + s1;
		} else if (rout == 2) {
			s0 = "xsmyoXee0" + s0;
			s1 = "byu0ppQp3" + s1 + ";l3." + s0;
		}
		return s0 + Salt + s1;
	}

	@Override
	public boolean checkPwd(String password, UserAccount userAccount) {
		String mix = mix(password);
		String salt = TokenUtil.parseToken(userAccount.getSalt());
		String digest = SHA1.digest(mix + salt);
		return digest.equals(userAccount.getPassword());
	}

	private String getToken(int userId, boolean keepLogin) {
		try {
			UserAccount userAccount = userAccountDao.find(userId);
			// TODO 是否保持登录
			return TokenUtil.generateToken(userId + "|" + userAccount.getUserLevel() + "|" + (keepLogin ? 1 : 0));
		} catch (SQLException e) {
			logger.error("find error", e);
		}
		return null;
	}

	@Override
	public String login(int userId, boolean keepLogin) {
		return getToken(userId, keepLogin);
	}

}
