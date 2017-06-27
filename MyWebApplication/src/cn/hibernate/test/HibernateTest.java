package cn.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.hibernate.entity.User;
import cn.hibernate.utils.HibernateUtils;

public class HibernateTest {
	@Test
	public void testAdd(){
//		（1）加载Hibernate核心配置文件
		// 在src下面找到hibernate.cfg.xml文件
		Configuration cfg = new Configuration();
		cfg.configure();
//		（2）创建SessionFactory对象
		// 读取hibernate核心配置文件内容，创建SessionFactory，在此过程中创建数据库表
		//SessionFactory sessionFactory = cfg.buildSessionFactory();
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
//		（3）使用SessionFactory创建Session对象
		Session session = sessionFactory.openSession();
//		（4）开启事务
		Transaction tx = session.beginTransaction();
//		（5）写业务逻辑CRUD操作
		User user = new User();
		user.setUsername("hibernate2");
		user.setPassword("1234567");
		user.setAddress("america");
		// 调用session中到方法实现添加
		session.save(user);
//		（6）提交事务
		tx.commit();
//		（7）关闭资源
		session.close();
		sessionFactory.close();
	}
}
