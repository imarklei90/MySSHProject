package cn.spring.web.service;

import cn.spring.web.dao.UserDao;

public class UserService {
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void add() {
		System.out.println("userService.....");
		userDao.add();
	}
}
