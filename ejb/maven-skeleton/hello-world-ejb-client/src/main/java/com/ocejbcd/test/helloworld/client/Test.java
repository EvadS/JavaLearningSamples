package com.ocejbcd.test.helloworld.client;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.ocejbcd.test.helloworld.Hello;

public class Test {
	private final Context context;
	private Hello hello;

	public Test() throws NamingException {
		final Properties jndiProperties = new Properties();
		jndiProperties.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		this.context = new InitialContext(jndiProperties);
	}

	private Hello lookupHelloBeanEJB() throws NamingException {
		return (Hello) context.lookup("ejb:/helloworld-ejb//HelloBean!com.ocejbcd.test.helloworld.Hello");
	}

	public String hello() throws NamingException {
		hello = this.lookupHelloBeanEJB();
		return hello.sayHello();
	}

	public static void main(String[] args) throws NamingException {
		Test test = new Test();
		System.out.println(test.hello());
	}
}