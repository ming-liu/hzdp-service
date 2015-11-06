package com.hzdp.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzdp.dao.UserAccountDao;
import com.hzdp.entity.UserAccount;
import com.hzdp.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	private UserAccountDao userAccountDao;

	public String sayHello() {
		UserAccount userAccount = null;
		try {
			userAccount = userAccountDao.find(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userAccount.getName();
	}

}
