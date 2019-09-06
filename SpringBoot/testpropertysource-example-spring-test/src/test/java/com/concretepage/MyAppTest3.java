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
@TestPropertySource(properties = { "login.user=krishna", "login.pwd=k12" })
public class MyAppTest3 {
	@Autowired
	private AuthService authService;

	@Test
	public void userTest() throws Exception {
		assertTrue("krishna".equals(authService.getUser()));
		assertTrue("k12".equals(authService.getPwd()));
		assertTrue("MyApp".equals(authService.getAppName()));
	}
}