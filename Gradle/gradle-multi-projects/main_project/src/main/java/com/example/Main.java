package com.example;

import org.apache.log4j.Logger;
import com.example.library.Simple;

public class Main {
	private static final Logger LOG = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		LOG.info("Application started");
		System.out.println("I'm the main project");
		Simple simple = new Simple();
		simple.setValue(10);
		System.out.println("Value from Simple: " + simple.getValue());
		LOG.info("Application finished");
	}
}