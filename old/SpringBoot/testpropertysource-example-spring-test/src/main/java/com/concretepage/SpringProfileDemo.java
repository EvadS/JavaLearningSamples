package com.concretepage;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringProfileDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.concretepage");		
		ctx.refresh();
		AuthService authService = ctx.getBean(AuthService.class);
		System.out.println(authService.getUser());
	}
}
