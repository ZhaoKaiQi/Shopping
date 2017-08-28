package com.qf.shopping.order.entity;

/**
 * 订单详情的实体
 * 
 * @ClassName: OrderDetail
 * @author 赵凯琦
 * @date 2017-5-26 下午8:12:00
 * 
 */
public class OrderDetail {
	private int oDId;// 订单详情Id
	private int oId;// 订单的Id

	public int getoDId() {
		return oDId;
	}

	public void setoDId(int oDId) {
		this.oDId = oDId;
	}

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}
}
