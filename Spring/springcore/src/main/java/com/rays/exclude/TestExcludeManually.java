package com.rays.exclude;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestExcludeManually {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("exclude.xml");

		UserService userService = context.getBean("userService", UserService.class);
		
		userService.greet();

		AnotherService anotherService = context.getBean("anotherService", AnotherService.class);
		
		anotherService.doSomething();

		UserService userServiceToExclude = null;

		userServiceToExclude = context.getBean("userServiceToExclude", UserService.class);

		userServiceToExclude.greet();

	}
}
