package com.rays.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestNotificationService {

	
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("primary.xml");
		NotificationService notificationService = (NotificationService) context.getBean("notificationService");
		notificationService.sendNotification("Hello, Spring!");
	}
}
