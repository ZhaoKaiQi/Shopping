package com.qf.shopping.order.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.qf.shopping.order.dao.IOrderDetailAndGoodDao;
import com.qf.shopping.order.dao.impl.OrderDetailAndGoodDao;
import com.qf.shopping.order.entity.OrderDetailAndGood;
import com.qf.shopping.order.service.IOrderDetailAndGoodService;

/**
 * �м��ҵ���߼����ʵ��
 * 
 * @ClassName: OrderDetailAndGoodService
 * @author �Կ���
 * @date 2017-5-27 ����3:09:42
 * 
 */
public class OrderDetailAndGoodService implements IOrderDetailAndGoodService {
	IOrderDetailAndGoodDao orderDetailAndGoodDao = new OrderDetailAndGoodDao();

	@Override
	public void addRelation(OrderDetailAndGood orderAndOrderDetail) {
		if (orderAndOrderDetail == null) {
			throw new RuntimeException("��ϵ��Ķ���Ϊnull");
		}
		orderDetailAndGoodDao.addRelation(orderAndOrderDetail);
	}

	@Override
	public List<OrderDetailAndGood> getOrderAndOrderDetailByoDId(int oDId) {
		if (oDId <= 0) {
			throw new RuntimeException("oDId���Ϸ�");
		}
		return orderDetailAndGoodDao.getOrderAndOrderDetailByoDId(oDId);
	}

}
