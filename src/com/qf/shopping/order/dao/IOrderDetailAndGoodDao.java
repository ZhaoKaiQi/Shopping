package com.qf.shopping.order.dao;

import java.sql.SQLException;
import java.util.List;

import com.qf.shopping.order.entity.OrderDetailAndGood;

/**
 * 商品和订单详情之间的关系表
 * @ClassName: IOrderDetailAndGoodDao 
 * @author 赵凯琦 
 * @date 2017-5-27 上午2:11:37 
 *
 */
public interface IOrderDetailAndGoodDao {
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
