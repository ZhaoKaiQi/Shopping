package com.qf.shopping.order.dao;

import java.sql.SQLException;
import java.util.List;

import com.qf.shopping.order.entity.OrderDetail;

/**
 * ���������dao�ӿ�
 * 
 * @ClassName: IOrderDetailDao
 * @author �Կ���
 * @date 2017-5-27 ����1:36:40
 * 
 */
public interface IOrderDetailDao {
	/**
	 * 
	 * @Title: getOrderDetailByOId
	 * @Description: ͨ��������ȥ�Ҷ�������
	 * @param @return
	 * @return OrderDetail
	 * @throws
	 */
	public List<OrderDetail> getOrderDetailByOId(int oId);

	/**
	 * @throws SQLException
	 * 
	 * @Title: addOrderDetail
	 * @Description: ��������������鵽���ݿ�
	 * @param @param orderDetail
	 * @return void
	 * @throws
	 */
	public void addOrderDetail(OrderDetail orderDetail) throws SQLException;

	/**
	 * @throws SQLException 
	 * 
	 * @Title: getGenarateKey
	 * @Description: ��ȡ������������ֵ
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int getGenarateKey() throws SQLException;
}
