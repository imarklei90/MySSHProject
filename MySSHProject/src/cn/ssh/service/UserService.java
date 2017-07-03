package cn.ssh.service;

import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.UserDao;

@Transactional
public class UserService {
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void add(){
		userDao.add();
	}
}
