package com.qf.shopping.order.entity;

/**
 * �����Ͷ�������֮����м��
 * 
 * @ClassName: OrderAndOrderDetail
 * @author �Կ���
 * @date 2017-5-27 ����1:28:06
 * 
 */

public class OrderDetailAndGood {
	private int ogId;// �м���Id
	private int oDId;// ���������Id
	private int gId;// ��Ʒ��Id

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
