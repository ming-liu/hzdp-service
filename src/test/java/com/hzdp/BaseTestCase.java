package com.hzdp;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:config/spring/spring-hzdp-service.xml" })
public abstract class BaseTestCase {

	protected final Logger logger = Logger.getLogger(getClass());
}
