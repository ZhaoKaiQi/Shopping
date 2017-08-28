package com.qf.shopping.order.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.qf.shopping.order.dao.IOrderDetailAndGoodDao;
import com.qf.shopping.order.dao.impl.OrderDetailAndGoodDao;
import com.qf.shopping.order.entity.OrderDetailAndGood;
import com.qf.shopping.order.service.IOrderDetailAndGoodService;

/**
 * 中间表业务逻辑层的实现
 * 
 * @ClassName: OrderDetailAndGoodService
 * @author 赵凯琦
 * @date 2017-5-27 上午3:09:42
 * 
 */
public class OrderDetailAndGoodService implements IOrderDetailAndGoodService {
	IOrderDetailAndGoodDao orderDetailAndGoodDao = new OrderDetailAndGoodDao();

	@Override
	public void addRelation(OrderDetailAndGood orderAndOrderDetail) {
		if (orderAndOrderDetail == null) {
			throw new RuntimeException("关系表的对象为null");
		}
		orderDetailAndGoodDao.addRelation(orderAndOrderDetail);
	}

	@Override
	public List<OrderDetailAndGood> getOrderAndOrderDetailByoDId(int oDId) {
		if (oDId <= 0) {
			throw new RuntimeException("oDId不合法");
		}
		return orderDetailAndGoodDao.getOrderAndOrderDetailByoDId(oDId);
	}

}
