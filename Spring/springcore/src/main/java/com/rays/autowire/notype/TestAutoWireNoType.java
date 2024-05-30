package com.rays.autowire.notype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutoWireNoType {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("autowire-no-type.xml");

		UserService userService = (UserService) context.getBean("userService");
		userService.testAdd();
	}
	
	

}
