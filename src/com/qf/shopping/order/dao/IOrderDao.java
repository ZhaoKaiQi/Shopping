package com.qf.shopping.order.dao;

import java.sql.SQLException;
import java.util.List;

import com.qf.shopping.order.entity.Order;

/**
 * ������dao�ӿ�
 * 
 * @ClassName: IOrderDao
 * @author �Կ���
 * @date 2017-5-26 ����8:18:09
 * 
 */
public interface IOrderDao {
	// �����û���Id��״̬��ѯ���ж���
	List<Order> getAllOrder(int uId);

	// �������ݵ�����
	void addOrder(Order order);

	// ����������������ֵ
	int getGenerateKey() throws SQLException;
}
