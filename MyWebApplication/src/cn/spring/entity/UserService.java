package cn.spring.entity;

public class UserService {

	private UserDao userDao = new UserDao();
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void add(){
		userDao.add();
		System.out.println("UserServie add...");
	}

	
}
