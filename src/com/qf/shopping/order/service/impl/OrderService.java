package com.qf.shopping.order.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.qf.shopping.order.dao.IOrderDao;
import com.qf.shopping.order.dao.impl.OrderDao;
import com.qf.shopping.order.entity.Order;
import com.qf.shopping.order.service.IOrderService;

/**
 * orderҵ���߼����ʵ����
 * 
 * @ClassName: OrderService
 * @author �Կ���
 * @date 2017-5-27 ����1:10:39
 * 
 */
public class OrderService implements IOrderService {
	IOrderDao orderDao = new OrderDao();

	@Override
	public List<Order> getAllOrder(int uId) throws Exception {
		if (uId <= 0) {
			throw new RuntimeException("�û�Id������");
		}
		return orderDao.getAllOrder(uId);
	}

	@Override
	public void addOrder(Order order) throws Exception {
		if (order == null) {
			throw new RuntimeException("����ʵ��Ϊnull");
		}
		orderDao.addOrder(order);
	}

	@Override
	public int getGenerateKey() throws SQLException {
		return orderDao.getGenerateKey();
	}
 
}
