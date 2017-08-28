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
 * ͨ������Idȥ�Ҷ�������
 * 
 * @ClassName: OrderDetailDao
 * @author �Կ���
 * @date 2017-5-27 ����1:41:34
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
			throw new RuntimeException("��ѯ������������쳣");
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
