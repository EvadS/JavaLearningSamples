package com.ocejbcd.test.helloworld;

import javax.ejb.Remote;

@Remote
public interface Hello {
	public String sayHello();

}
