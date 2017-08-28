package com.qf.shopping.card.entity;

import com.qf.shopping.product.entity.Product;

/**
 * ���ﳵ�й�����ģ��
 * 
 * @ClassName: CardItem
 * @author �Կ���
 * @date 2017-5-26 ����3:14:18
 * 
 */
public class CardItem {
	private Product product;// ��Ʒ
	private int productCount;// ��Ʒ������
	private float subTotalPrice;// ��Ʒ��С��

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public float getSubTotalPrice() {
		return subTotalPrice;
	}

	public void setSubTotalPrice(float subTotalPrice) {
		this.subTotalPrice = subTotalPrice;
	}

	public CardItem(Product product, int productCount, float subTotalPrice) {
		super();
		this.product = product;
		this.productCount = productCount;
		this.subTotalPrice = subTotalPrice;
	}

	public CardItem() {
		super();
	}

}
