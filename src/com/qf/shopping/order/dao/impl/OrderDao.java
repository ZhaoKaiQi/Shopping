package com.qf.shopping.order.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.shopping.order.dao.IOrderDao;
import com.qf.shopping.order.entity.Order;
import com.qf.shopping.utils.JDBCUtils;
import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * 订单的dao层实现类
 * 
 * @ClassName: OrderDao
 * @author 赵凯琦
 * @date 2017-5-26 下午8:30:11
 * 
 */
public class OrderDao implements IOrderDao {

	@Override
	public List<Order> getAllOrder(int uId) {
		QueryRunner runner = JDBCUtils.getQueryRunner();
		String sql = "select * from t_order where t_order.uId=?";
		// 下面进行查询的执行
		try {
			List<Order> orders = runner.query(sql, new BeanListHandler<Order>(
					Order.class), uId);
			if (orders != null) {
				return orders;
			}
		} catch (SQLException e) {
			throw new RuntimeException("查询用户订单失败");
		}
		return null;
	}

	@Override
	public void addOrder(Order order) {
		QueryRunner runner = JDBCUtils.getQueryRunner();
		String sql = "insert into t_order(uId,oTime,oState,oTotalPrice) values (?,?,?,?)";
		// 下面进行查询的执行
		try {
			runner.update(sql, order.getuId(), order.getoTime(),
					order.getoState(), order.getoTotalPrice());
		} catch (SQLException e) {
			throw new RuntimeException("这个地方存在一个外键插不进去的问题"+e);
		}
	}

	@Override
	public int getGenerateKey() throws SQLException {
		QueryRunner runner = JDBCUtils.getQueryRunner();
		String sql = "select oId from t_order";
		List<Order> lists=runner.query(sql,new BeanListHandler<Order>(Order.class));
		if (lists.size()<=0) {
			return 0;
		}
		return lists.get(lists.size()-1).getoId();
	}

}
