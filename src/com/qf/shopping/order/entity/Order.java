package com.qf.shopping.order.entity;

import java.util.Date;

/**
 * ���������ʵ��
 * 
 * @ClassName: Order
 * @author �Կ���
 * @date 2017-5-26 ����7:59:17
 * 
 */
public class Order {
	private int oId;// ������Id
	private int uId;// �û���Id
	private Date oTime;// �µ���ʱ��
	private float oTotalPrice;// �ܼ�
	private int oState;// ����״̬

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
