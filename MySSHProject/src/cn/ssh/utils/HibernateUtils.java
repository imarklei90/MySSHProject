package cn.ssh.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 静态代码块实现SessionFactory创建
 * @author iustc
 *
 */
public class HibernateUtils {
	static Configuration configuration = null;
	static SessionFactory sessionFactory = null;
	static Session session = null;
	static{
		configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	
	// 返回 SessionFactory
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	// 返回Session
	public Session getSession(){
		return session = sessionFactory.getCurrentSession();
	}
}
