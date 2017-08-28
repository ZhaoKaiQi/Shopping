package com.qf.shopping.card.entity;

import com.qf.shopping.product.entity.Product;

/**
 * 购物车中购物项模块
 * 
 * @ClassName: CardItem
 * @author 赵凯琦
 * @date 2017-5-26 上午3:14:18
 * 
 */
public class CardItem {
	private Product product;// 商品
	private int productCount;// 商品的数量
	private float subTotalPrice;// 商品的小计

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
