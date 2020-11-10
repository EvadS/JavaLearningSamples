package com.concretepage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("com.concretepage")
@PropertySource("classpath:auth.properties")
public class AppConfig {
    @Autowired
    Environment env;


	@Bean
	public AuthService myService() {
		System.out.println("port :  " + env.getProperty("server.port"));

		AuthService myService = new AuthService(
				env.getProperty("login.user"),
				env.getProperty("login.pwd"),
				env.getProperty("app.name")
			);
		return myService;
	}
}
