package com.rays.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrder2 {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Order2.xml");

		Order2 order = (Order2) context.getBean("order2");

		order.bookATicket(1);

	}


}
