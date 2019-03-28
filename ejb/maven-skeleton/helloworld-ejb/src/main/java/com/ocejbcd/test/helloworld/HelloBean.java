package com.ocejbcd.test.helloworld;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloBean
 */
@Stateless
@LocalBean
public class HelloBean implements Hello {

    /**
     * Default constructor. 
     */
    public HelloBean() {
    }

	@Override
	public String sayHello() {
		return "TODO Auto-generated method stub!!!!";
	}

}
