package com.qf.shopping.user.entity;

public class User {
	private int uId;// ���
	private String uName;// �û���
	private String uPassword;// ����
	private String uCode;// ������
	private int uState;// ״̬��0δ���1������

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuCode() {
		return uCode;
	}

	public void setuCode(String uCode) {
		this.uCode = uCode;
	}

	public int getuState() {
		return uState;
	}

	public void setuState(int uState) {
		this.uState = uState;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uPassword="
				+ uPassword + ", uCode=" + uCode + ", uState=" + uState + "]";
	}

}
