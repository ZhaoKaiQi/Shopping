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
 * ������dao��ʵ����
 * 
 * @ClassName: OrderDao
 * @author �Կ���
 * @date 2017-5-26 ����8:30:11
 * 
 */
public class OrderDao implements IOrderDao {

	@Override
	public List<Order> getAllOrder(int uId) {
		QueryRunner runner = JDBCUtils.getQueryRunner();
		String sql = "select * from t_order where t_order.uId=?";
		// ������в�ѯ��ִ��
		try {
			List<Order> orders = runner.query(sql, new BeanListHandler<Order>(
					Order.class), uId);
			if (orders != null) {
				return orders;
			}
		} catch (SQLException e) {
			throw new RuntimeException("��ѯ�û�����ʧ��");
		}
		return null;
	}

	@Override
	public void addOrder(Order order) {
		QueryRunner runner = JDBCUtils.getQueryRunner();
		String sql = "insert into t_order(uId,oTime,oState,oTotalPrice) values (?,?,?,?)";
		// ������в�ѯ��ִ��
		try {
			runner.update(sql, order.getuId(), order.getoTime(),
					order.getoState(), order.getoTotalPrice());
		} catch (SQLException e) {
			throw new RuntimeException("����ط�����һ������岻��ȥ������"+e);
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
