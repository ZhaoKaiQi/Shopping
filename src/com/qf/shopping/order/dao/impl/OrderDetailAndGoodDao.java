package com.qf.shopping.order.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.shopping.order.dao.IOrderDetailAndGoodDao;
import com.qf.shopping.order.entity.OrderDetailAndGood;
import com.qf.shopping.utils.JDBCUtils;

/**
 * �����������Ʒ��Ĺ�ϵ��
 * 
 * @ClassName: OrderDetailAndGoodDao
 * @author �Կ���
 * @date 2017-5-27 ����2:20:07
 * 
 */
public class OrderDetailAndGoodDao implements IOrderDetailAndGoodDao {

	@Override
	public void addRelation(OrderDetailAndGood orderAndOrderDetail) {
		QueryRunner runner = JDBCUtils.getQueryRunner();
		String sql = "insert into t_relation(gId,oDId) values(?,?)";
		try {
			runner.update(sql, orderAndOrderDetail.getgId(),
					orderAndOrderDetail.getoDId());
		} catch (SQLException e) {
			throw new RuntimeException("������ݵ���ϵ���������");
		}
	}

	@Override
	public List<OrderDetailAndGood> getOrderAndOrderDetailByoDId(int oDId) {
		QueryRunner runner = JDBCUtils.getQueryRunner();
		String sql = "select * from t_relation where oDId=?";
		List<OrderDetailAndGood> orderDetailAndGoods;
		try {
			orderDetailAndGoods = runner.query(sql,
					new BeanListHandler<OrderDetailAndGood>(
							OrderDetailAndGood.class), oDId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return orderDetailAndGoods;
	}
}
