package com.qf.shopping.order.dao;

import java.sql.SQLException;
import java.util.List;

import com.qf.shopping.order.entity.OrderDetailAndGood;

/**
 * ��Ʒ�Ͷ�������֮��Ĺ�ϵ��
 * @ClassName: IOrderDetailAndGoodDao 
 * @author �Կ��� 
 * @date 2017-5-27 ����2:11:37 
 *
 */
public interface IOrderDetailAndGoodDao {
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
