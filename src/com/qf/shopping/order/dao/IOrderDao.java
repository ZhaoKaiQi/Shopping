package com.qf.shopping.order.dao;

import java.sql.SQLException;
import java.util.List;

import com.qf.shopping.order.entity.Order;

/**
 * 订单的dao接口
 * 
 * @ClassName: IOrderDao
 * @author 赵凯琦
 * @date 2017-5-26 下午8:18:09
 * 
 */
public interface IOrderDao {
	// 根据用户的Id和状态查询所有订单
	List<Order> getAllOrder(int uId);

	// 插入数据到订单
	void addOrder(Order order);

	// 返回主键自增长的值
	int getGenerateKey() throws SQLException;
}
