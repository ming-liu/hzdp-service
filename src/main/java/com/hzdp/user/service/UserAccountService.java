package com.hzdp.user.service;

import java.util.List;

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
	String login(UserAccount userAccount, boolean keepLogin);

	UserAccount findById(int id);
	UserAccount findByMobile(String mobile);

	int create(UserAccount userAccount);

	boolean checkPwd(String password, UserAccount userAccount);
	
	int parseToken(String token);
	
	List<UserAccount> findByIds(List<Integer> userIds);
	
}
