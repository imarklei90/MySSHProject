package cn.ssh.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.ssh.entity.User;


public class UserDaoImpl implements UserDao{
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void add(){
//		User user = new User();
//		user.setUsername("admin");
//		user.setPassword("123");
//		
//		hibernateTemplate.save(user);
		
		// get : 根据ID查询 load是延迟查询
//		User user = hibernateTemplate.get(User.class, 1);
//		System.out.println(user.getUsername() + "---->" + user.getPassword());
		
		//查询所有记录
//		List<User> list = (List<User>) hibernateTemplate.find("from User");
//		for(User user : list){
//			System.out.println(user.getUsername() + ":" + user.getPassword());
//		}
		
		// find条件查询
		List<User> list = (List<User>) hibernateTemplate.find("from User where username=?", "admin");
		for(User user : list){
			System.out.println(user.getUsername() + ":" + user.getPassword());
		}
	}
	
}
