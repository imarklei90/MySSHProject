package cn.spring.xmlannotation;

import javax.annotation.Resource;

public class BookService {
	
	@Resource(name="bookDao")
	private BookDao bookDao;
	
	@Resource(name="orderDao")
	private OrderDao orderDao;
	
	public void book(){
		System.out.println("Book Service......");
		bookDao.add();
		orderDao.add();
	}
}
