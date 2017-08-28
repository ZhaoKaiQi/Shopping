package com.qf.shopping.order.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.shopping.order.entity.OrderDetailAndGood;

/**
 * ��Ʒ�Ͷ��������ҵ���߼���
 * 
 * @ClassName: IOrderDetailAndGoodService
 * @author �Կ���
 * @date 2017-5-27 ����3:04:43
 * 
 */
public interface IOrderDetailAndGoodService {
	/**
	 * 
	 * @Title: addRelation
	 * @Description: �����Ʒ�Ͷ�������Ĺ�ϵ����
	 * @param @param orderAndOrderDetail
	 * @return void
	 * @throws
	 */
	void addRelation(OrderDetailAndGood orderAndOrderDetail);

	/**
	 * @throws SQLException
	 * 
	 * @Title: getOrderAndOrderDetailByoDId
	 * @Description: ���ݶ��������Id��ȡ��Ʒ
	 * @param @param oDId
	 * @param @return
	 * @return List<OrderAndOrderDetail>
	 * @throws
	 */
	List<OrderDetailAndGood> getOrderAndOrderDetailByoDId(int oDId);
}
