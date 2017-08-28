package com.qf.shopping.order.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.shopping.order.entity.OrderDetail;

/**
 * ���������ҵ���߼���ӿ�
 * 
 * @ClassName: IOrderDetailService
 * @author �Կ���
 * @date 2017-5-27 ����1:55:44
 * 
 */
public interface IOrderDetailService {
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
	 * @Description:���涩�����鵽���ݿ�
	 * @param @param orderDetail
	 * @return void
	 * @throws
	 */
	public void addOrderDetail(OrderDetail orderDetail) throws SQLException;
/**
 * 
 * @Title: getGenarateKey 
 * @Description: ��ȡ����������������ֵ
 * @param @return
 * @return int
 * @throws
 */
	public int getGenarateKey() throws SQLException;
	
}
