package com.concretepage;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
@TestPropertySource(properties = { "login.user=mahesh" })
public class MyAppTest4 extends AnotherTest {
	@Autowired
	private AuthService authService;

	@Test
	public void userTest() throws Exception {
		assertTrue("mahesh".equals(authService.getUser()));
		assertTrue("s12".equals(authService.getPwd()));
		assertTrue("MyApp".equals(authService.getAppName()));
	}
}

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
@TestPropertySource("/testauth.properties")
class AnotherTest {
	@Autowired
	private AuthService authService;

	@Test
	public void anotherUserTest() throws Exception {
		assertTrue("s12".equals(authService.getPwd()));
		assertTrue("MyApp".equals(authService.getAppName()));
	}
}