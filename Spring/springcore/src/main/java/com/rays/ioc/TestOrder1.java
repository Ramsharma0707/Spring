package com.rays.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrder1 {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Order1.xml");

		Order1 order = (Order1) context.getBean("order1");

		order.bookATicket(4);

	}
}
