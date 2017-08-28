package com.qf.shopping.order.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.shopping.order.entity.OrderDetailAndGood;

/**
 * 商品和订单详情的业务逻辑层
 * 
 * @ClassName: IOrderDetailAndGoodService
 * @author 赵凯琦
 * @date 2017-5-27 上午3:04:43
 * 
 */
public interface IOrderDetailAndGoodService {
	/**
	 * 
	 * @Title: addRelation
	 * @Description: 添加商品和订单详情的关系数据
	 * @param @param orderAndOrderDetail
	 * @return void
	 * @throws
	 */
	void addRelation(OrderDetailAndGood orderAndOrderDetail);

	/**
	 * @throws SQLException
	 * 
	 * @Title: getOrderAndOrderDetailByoDId
	 * @Description: 根据订单详情的Id获取商品
	 * @param @param oDId
	 * @param @return
	 * @return List<OrderAndOrderDetail>
	 * @throws
	 */
	List<OrderDetailAndGood> getOrderAndOrderDetailByoDId(int oDId);
}
