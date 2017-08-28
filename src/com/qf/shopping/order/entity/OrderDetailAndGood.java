package com.qf.shopping.order.entity;

/**
 * 订单和订单详情之间的中间表
 * 
 * @ClassName: OrderAndOrderDetail
 * @author 赵凯琦
 * @date 2017-5-27 上午1:28:06
 * 
 */

public class OrderDetailAndGood {
	private int ogId;// 中间表的Id
	private int oDId;// 订单详情的Id
	private int gId;// 商品的Id

	public int getOgId() {
		return ogId;
	}

	public void setOgId(int ogId) {
		this.ogId = ogId;
	}

	public int getoDId() {
		return oDId;
	}

	public void setoDId(int oDId) {
		this.oDId = oDId;
	}

	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId = gId;
	}
}
