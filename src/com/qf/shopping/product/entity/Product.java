package com.qf.shopping.product.entity;

/**
 * 产品的实体
 * 
 * @ClassName: Product
 * @author 赵凯琦
 * @date 2017-5-26 上午1:13:57
 * 
 */
public class Product {
	private int gId;
	private String gName;
	private String gSmallPic;
	private String gBigPic;
	private float gPrice;
	private float gVipPrice;
	private float gSvipPrice;
	private String gDes;
	private int cId;// 分类列表中的ID

	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId = gId;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getgSmallPic() {
		return gSmallPic;
	}

	public void setgSmallPic(String gSmallPic) {
		this.gSmallPic = gSmallPic;
	}

	public String getgBigPic() {
		return gBigPic;
	}

	public void setgBigPic(String gBigPic) {
		this.gBigPic = gBigPic;
	}

	public float getgPrice() {
		return gPrice;
	}

	public void setgPrice(float gPrice) {
		this.gPrice = gPrice;
	}

	public float getgVipPrice() {
		return gVipPrice;
	}

	public void setgVipPrice(float gVipPrice) {
		this.gVipPrice = gVipPrice;
	}

	public float getgSvipPrice() {
		return gSvipPrice;
	}

	public void setgSvipPrice(float gSvipPrice) {
		this.gSvipPrice = gSvipPrice;
	}

	public String getgDes() {
		return gDes;
	}

	public void setgDes(String gDes) {
		this.gDes = gDes;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public Product(int gId, String gName, String gSmallPic, String gBigPic,
			float gPrice, float gVipPrice, float gSvipPrice, String gDes,
			int cId) {
		super();
		this.gId = gId;
		this.gName = gName;
		this.gSmallPic = gSmallPic;
		this.gBigPic = gBigPic;
		this.gPrice = gPrice;
		this.gVipPrice = gVipPrice;
		this.gSvipPrice = gSvipPrice;
		this.gDes = gDes;
		this.cId = cId;
	}

	public Product() {
		super();
	}

}
