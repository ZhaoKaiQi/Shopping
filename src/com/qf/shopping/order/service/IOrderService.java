package com.qf.shopping.order.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.shopping.order.entity.Order;

/**
 * ҵ���߼����order�ӿ�
 * 
 * @ClassName: IOrderService
 * @author �Կ���
 * @date 2017-5-27 ����12:46:46
 * 
 */
public interface IOrderService {
	// �����û���Id��״̬��ѯ���ж���
	List<Order> getAllOrder(int uId) throws Exception;

	// �������ݵ�����
	void addOrder(Order order) throws Exception;

	// ����������������ֵ
	int getGenerateKey() throws SQLException;
}
