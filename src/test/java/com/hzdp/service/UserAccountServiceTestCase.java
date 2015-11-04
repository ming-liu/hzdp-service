package com.hzdp.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hzdp.BaseTestCase;

public class UserAccountServiceTestCase extends BaseTestCase {

	@Autowired
	private UserAccountService userAccountService;

	@Test
	public void testSayHello() {
		String sayHello = userAccountService.sayHello();
		logger.info(sayHello);
	}
}
