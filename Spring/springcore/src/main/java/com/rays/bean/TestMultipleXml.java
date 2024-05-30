package com.rays.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMultipleXml {
	
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "UserBean.xml", "Person.xml" });

		UserBean user = (UserBean) context.getBean("user");

		System.out.println(user.getLogin());
		System.out.println(user.getPassword());

		Person person = (Person) context.getBean("personBean");

		System.out.println(person.getName());

	}

}
