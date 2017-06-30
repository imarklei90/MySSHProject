package cn.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apple.eawt.Application;

import cn.spring.aop.Book;
import cn.spring.entity.UserService;
import cn.spring.ioc.User;
import cn.spring.xmlannotation.BookService;

public class TestCase {
	
	@Test
	public void test(){
		// 加载Spring配置文件，创建对象
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 得到配置创建的对象(根据bean中的ID获取)
		User user = (User) context.getBean("user");
		System.out.println(user);
		user.add();
	}
	
	@Test // 测试依赖注入
	public void testInjectObject(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)context.getBean("userService");
		userService.add();
	}
	
	@Test // 测试注解方式的配置（创建对象）
	public void testAnnotation(){
		ApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
		cn.spring.annotation.User user  = (cn.spring.annotation.User)context.getBean("user");
		System.out.println(user);
		user.add();
	}
	
	@Test // 测试注解方式注入属性值
	public void testAnnotationProperty() {
		ApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
		cn.spring.annotation.UserService userService = (cn.spring.annotation.UserService)context.getBean("userService");
		userService.add();
	}
	
	@Test // 测试XML和Annotation混合的方式注入属性
	public void testXMLAndAnnotation(){
		ApplicationContext context = new ClassPathXmlApplicationContext("xmlannotation.xml");
		BookService bookService = (BookService) context.getBean("bookService");
		bookService.book();
	}
	
	@Test //测试Aop
	public void testAop(){
		ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		Book book = (Book) context.getBean("book");
		book.add();
	}
	
}
