package com.qf.shopping.order.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.shopping.order.dao.IOrderDetailDao;
import com.qf.shopping.order.entity.Order;
import com.qf.shopping.order.entity.OrderDetail;
import com.qf.shopping.utils.JDBCUtils;

/**
 * 通过订单Id去找订单详情
 * 
 * @ClassName: OrderDetailDao
 * @author 赵凯琦
 * @date 2017-5-27 上午1:41:34
 * 
 */
public class OrderDetailDao implements IOrderDetailDao {

	@Override
	public List<OrderDetail> getOrderDetailByOId(int oId) {
		QueryRunner runner = JDBCUtils.getQueryRunner();
		String sql = "select * from t_orderDetail where oId=?";
		List<OrderDetail> details;
		try {
			details = runner.query(sql, new BeanListHandler<OrderDetail>(
					OrderDetail.class), oId);
			if (details != null) {
				return details;
			}
		} catch (SQLException e) {
			throw new RuntimeException("查询订单详情出现异常");
		}

		return null;
	}

	@Override
	public void addOrderDetail(OrderDetail orderDetail) throws SQLException {
		QueryRunner runner = JDBCUtils.getQueryRunner();
		String sql ="insert into t_orderDetail(oId) values(?)";
		runner.update(sql,orderDetail.getoId());
	}

	@Override
	public int getGenarateKey() throws SQLException {
		QueryRunner runner = JDBCUtils.getQueryRunner();
		String sql = "select * from t_orderDetail";
		List<OrderDetail> lists=runner.query(sql,new BeanListHandler<OrderDetail>(OrderDetail.class));
		if (lists.size()<=0) {
			return 0;
		}
		return lists.get(lists.size()-1).getoDId();
	}

}
