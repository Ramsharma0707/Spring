package com.rays.autowire.byconstructor;

public class UserService {

	private UserDao userDao;

	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public void testAdd() {
		userDao.add();
	}

}
