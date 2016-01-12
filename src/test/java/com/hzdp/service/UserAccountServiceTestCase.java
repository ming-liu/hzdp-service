package com.hzdp.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hzdp.BaseTestCase;
import com.hzdp.entity.UserAccount;
import com.hzdp.user.service.UserAccountService;

public class UserAccountServiceTestCase extends BaseTestCase {

	@Autowired
	private UserAccountService userAccountService;

	@Test
	public void testFindByIds() {
		List<UserAccount> userAccounts = userAccountService.findByIds(Arrays.asList(2, 3, 4, 5));
		logger.info(userAccounts.size());
	}

}
