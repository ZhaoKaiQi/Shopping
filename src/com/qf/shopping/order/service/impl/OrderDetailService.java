package com.qf.shopping.order.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.qf.shopping.order.dao.IOrderDetailDao;
import com.qf.shopping.order.dao.impl.OrderDetailDao;
import com.qf.shopping.order.entity.OrderDetail;
import com.qf.shopping.order.service.IOrderDetailService;
/**
 * 订单详情的业务逻辑层实现类
 * @ClassName: OrderDetailService 
 * @author 赵凯琦 
 * @date 2017-5-27 上午1:58:27 
 *
 */
public class OrderDetailService implements IOrderDetailService{
IOrderDetailDao orderDetailDao=new OrderDetailDao();
	@Override
	public List<OrderDetail> getOrderDetailByOId(int oId) {
		if (oId<=0) {
			throw new RuntimeException("oId有问题");
		}
		return orderDetailDao.getOrderDetailByOId(oId);
	}
	@Override
	public void addOrderDetail(OrderDetail orderDetail) throws SQLException {
if (orderDetail==null) {
	throw new RuntimeException("订单详情为：null");
}
orderDetailDao.addOrderDetail(orderDetail);
	}
	@Override
	public int getGenarateKey() throws SQLException {
		return orderDetailDao.getGenarateKey();
	}

}
