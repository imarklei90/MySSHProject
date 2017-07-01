package cn.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.spring.c3p0.UserService;

public class C3p0Test {
	@Test
	public void testC3p0(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("c3p0.xml");
		UserService userService = (UserService) context.getBean("userService");
		userService.add();
	}
}
