package cn.spring.transaction.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.spring.transaction.service.OrderService;

public class TransactionTest {
	@Test
	public void testAccount(){
		ApplicationContext context = new ClassPathXmlApplicationContext("transaction.xml");
		OrderService orderService = (OrderService) context.getBean("orderService");
		orderService.doAccount();
	}
}