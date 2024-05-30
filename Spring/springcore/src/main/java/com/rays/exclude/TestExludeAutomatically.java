package com.rays.exclude;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestExludeAutomatically {

	
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("exclude.xml");

		TestAutowire testAutowire = context.getBean(TestAutowire.class);
		testAutowire.performOperations();
	}
}
