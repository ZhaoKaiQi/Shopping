package com.qf.shopping.order.entity;

import java.util.Date;

/**
 * 订单的这个实体
 * 
 * @ClassName: Order
 * @author 赵凯琦
 * @date 2017-5-26 下午7:59:17
 * 
 */
public class Order {
	private int oId;// 订单的Id
	private int uId;// 用户的Id
	private Date oTime;// 下单的时间
	private float oTotalPrice;// 总价
	private int oState;// 订单状态

	public void setoState(int oState) {
		this.oState = oState;
	}

	public int getoState() {
		return oState;
	}

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public Date getoTime() {
		return oTime;
	}

	public void setoTime(Date oTime) {
		this.oTime = oTime;
	}

	public float getoTotalPrice() {
		return oTotalPrice;
	}

	public void setoTotalPrice(float oTotalPrice) {
		this.oTotalPrice = oTotalPrice;
	}

}
