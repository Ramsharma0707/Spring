package com.rays.autowire.bytype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutoWireByType {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("autowire-bytype.xml");

		UserService userService = (UserService) context.getBean("userService");
		userService.testAdd();
	}

}
