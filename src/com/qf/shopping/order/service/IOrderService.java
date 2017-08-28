package com.qf.shopping.order.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.shopping.order.entity.Order;

/**
 * 业务逻辑层的order接口
 * 
 * @ClassName: IOrderService
 * @author 赵凯琦
 * @date 2017-5-27 上午12:46:46
 * 
 */
public interface IOrderService {
	// 根据用户的Id和状态查询所有订单
	List<Order> getAllOrder(int uId) throws Exception;

	// 插入数据到订单
	void addOrder(Order order) throws Exception;

	// 返回主键自增长的值
	int getGenerateKey() throws SQLException;
}
