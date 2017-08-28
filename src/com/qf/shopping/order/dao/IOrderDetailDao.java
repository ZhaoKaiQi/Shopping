package com.qf.shopping.order.dao;

import java.sql.SQLException;
import java.util.List;

import com.qf.shopping.order.entity.OrderDetail;

/**
 * 订单详情的dao接口
 * 
 * @ClassName: IOrderDetailDao
 * @author 赵凯琦
 * @date 2017-5-27 上午1:36:40
 * 
 */
public interface IOrderDetailDao {
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
	 * @Description: 保存这个订单详情到数据库
	 * @param @param orderDetail
	 * @return void
	 * @throws
	 */
	public void addOrderDetail(OrderDetail orderDetail) throws SQLException;

	/**
	 * @throws SQLException 
	 * 
	 * @Title: getGenarateKey
	 * @Description: 获取主键自增长的值
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int getGenarateKey() throws SQLException;
}
