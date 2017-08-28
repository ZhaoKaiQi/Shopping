package com.qf.shopping.order.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.qf.shopping.order.dao.IOrderDetailDao;
import com.qf.shopping.order.dao.impl.OrderDetailDao;
import com.qf.shopping.order.entity.OrderDetail;
import com.qf.shopping.order.service.IOrderDetailService;
/**
 * ���������ҵ���߼���ʵ����
 * @ClassName: OrderDetailService 
 * @author �Կ��� 
 * @date 2017-5-27 ����1:58:27 
 *
 */
public class OrderDetailService implements IOrderDetailService{
IOrderDetailDao orderDetailDao=new OrderDetailDao();
	@Override
	public List<OrderDetail> getOrderDetailByOId(int oId) {
		if (oId<=0) {
			throw new RuntimeException("oId������");
		}
		return orderDetailDao.getOrderDetailByOId(oId);
	}
	@Override
	public void addOrderDetail(OrderDetail orderDetail) throws SQLException {
if (orderDetail==null) {
	throw new RuntimeException("��������Ϊ��null");
}
orderDetailDao.addOrderDetail(orderDetail);
	}
	@Override
	public int getGenarateKey() throws SQLException {
		return orderDetailDao.getGenarateKey();
	}

}
