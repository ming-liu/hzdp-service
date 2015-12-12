package com.hzdp.user.service;

import com.hzdp.entity.UserAccount;

public interface UserAccountService {

	/**
	 * return token
	 * 
	 * @param userId
	 * @param keepLogin
	 * @return
	 */
	String login(int userId, boolean keepLogin);

	UserAccount findByMobile(String mobile);

	int create(UserAccount userAccount);

	boolean checkPwd(String password, UserAccount userAccount);
}
