package com.qf.shopping.order.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.qf.shopping.order.dao.IOrderDao;
import com.qf.shopping.order.dao.impl.OrderDao;
import com.qf.shopping.order.entity.Order;
import com.qf.shopping.order.service.IOrderService;

/**
 * order业务逻辑层的实现类
 * 
 * @ClassName: OrderService
 * @author 赵凯琦
 * @date 2017-5-27 上午1:10:39
 * 
 */
public class OrderService implements IOrderService {
	IOrderDao orderDao = new OrderDao();

	@Override
	public List<Order> getAllOrder(int uId) throws Exception {
		if (uId <= 0) {
			throw new RuntimeException("用户Id有问题");
		}
		return orderDao.getAllOrder(uId);
	}

	@Override
	public void addOrder(Order order) throws Exception {
		if (order == null) {
			throw new RuntimeException("订单实体为null");
		}
		orderDao.addOrder(order);
	}

	@Override
	public int getGenerateKey() throws SQLException {
		return orderDao.getGenerateKey();
	}
 
}
