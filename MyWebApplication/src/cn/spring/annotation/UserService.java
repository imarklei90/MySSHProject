package cn.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserService {
	// 在dao属性上使用注解，完成对象注入，不需要使用Set方法
	@Autowired
	private UserDao userDao;
	
	public void add(){
		System.out.println("userService......");
		userDao.add();
	}
}
