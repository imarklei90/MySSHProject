package cn.spring.transaction.service;

import org.springframework.transaction.annotation.Transactional;

import cn.spring.transaction.dao.OrderDao;

@Transactional
public class OrderService {
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	/**
	 * 转账业务
	 */
	public void doAccount(){
		orderDao.descSalary();
		// 出现异常
		int i = 1/0;
		orderDao.incrSalary();
	}
}
