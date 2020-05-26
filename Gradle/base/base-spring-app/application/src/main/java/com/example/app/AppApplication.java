package com.example.demo;

import com.example.demo.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class AppApplication //implements CommandLineRunner
 {

	private static Logger LOG = LoggerFactory.getLogger(AppApplication.class);

//	@Autowired
//	MyService service;



//	@Override
	public void run(String... args) throws Exception {

			LOG.info("EXECUTING : command line runner");

			for (int i = 0; i < args.length; ++i) {
				LOG.info("args[{}]: {}", i, args[i]);
			}

		System.out.println("---------------- > ");
	//	service.message();
		System.out.println("---------------- > ");

	}
}
