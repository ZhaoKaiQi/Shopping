package com.qf.shopping.order.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.shopping.order.entity.OrderDetail;

/**
 * 订单详情的业务逻辑层接口
 * 
 * @ClassName: IOrderDetailService
 * @author 赵凯琦
 * @date 2017-5-27 上午1:55:44
 * 
 */
public interface IOrderDetailService {
	/**
	 * 
	 * @Title: getOrderDetailByOId
	 * @Description: 通过订单号去找订单详情
	 * @param @return
	 * @return OrderDetail
	 * @throws
	 */
	public List<OrderDetail> getOrderDetailByOId(int oId);

	/**
	 * @throws SQLException 
	 * 
	 * @Title: addOrderDetail
	 * @Description:保存订单详情到数据库
	 * @param @param orderDetail
	 * @return void
	 * @throws
	 */
	public void addOrderDetail(OrderDetail orderDetail) throws SQLException;
/**
 * 
 * @Title: getGenarateKey 
 * @Description: 获取订单详情自增长的值
 * @param @return
 * @return int
 * @throws
 */
	public int getGenarateKey() throws SQLException;
	
}
