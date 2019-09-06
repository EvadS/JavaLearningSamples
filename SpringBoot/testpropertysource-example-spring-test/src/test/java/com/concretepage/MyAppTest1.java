package com.concretepage;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class MyAppTest1 {
	@Autowired
	private AuthService authService;
	
    @Test
    public void userTest() throws Exception {
    	assertTrue("ram".equals(authService.getUser()));
    	assertTrue("r12".equals(authService.getPwd()));
    	assertTrue("MyApp".equals(authService.getAppName()));    	
    }	
}