package com.qf.shopping.card.entity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.qf.shopping.product.entity.Product;

/**
 * 购物车这个对象 ,这两个购物车的对象因为只和业务逻辑层打交道的，所以不需要写Dao层(Dao层是用来访问数据库的)
 * 
 * @ClassName: Card
 * @author 赵凯琦
 * @date 2017-5-26 上午3:31:09
 * 
 */
public class Card {
	// 下面这个是维护的购物项
	private Map<Integer, CardItem> cardItems = new LinkedHashMap<Integer, CardItem>();
	// 维护总的价格
	private float totalPrice = 0;
	// 再维护一个属性，这个属性主要用来保存单例集合的购物项
	Collection<CardItem> cardItems2 = cardItems.values();

	public Collection<CardItem> getCardItems2() {
		return cardItems2;
	}

	public Map<Integer, CardItem> getCardItems() {
		return cardItems;
	}

	public void setCardItems(Map<Integer, CardItem> cardItems) {
		this.cardItems = cardItems;
	}

	/**
	 * 
	 * @Title: getTotalPrice
	 * @Description: 获取所有商品价格的总和
	 * @param @return
	 * @return float
	 * @throws
	 */
	public float getTotalPrice() {
		// 这个地方要计算出总的价格
		Collection<CardItem> values = cardItems.values();
		for (CardItem cardItem : values) {
			totalPrice += cardItem.getSubTotalPrice();
		}
		return totalPrice;
	}

	/**
	 * 
	 * @Title: clearCard
	 * @Description: 清空购物车的方法
	 * @param
	 * @return void
	 * @throws
	 */
	public void clearCard() {
		cardItems.clear();
	}

	/**
	 * 
	 * @Title: addCard
	 * @Description: 添加数据到购物车的方法
	 * @param @param product
	 * @return void
	 * @throws
	 */
	public void addCard(Product product) {
		// 判断购物车中是否有这个商品了
		Set<Integer> keySet = cardItems.keySet();
		for (Integer gId : keySet) {
			if (product.getgId() == gId) {
				// 说明这个商品已经在购物车中了，只需要数量加一就可以啦
				// 取出这个商品所在的购物项
				CardItem cardItem = cardItems.get(gId);
				// 下面解决数量加一和价格变化的问题
				cardItem.setProductCount(cardItem.getProductCount() + 1);
				// 改变单个商品价格
				cardItem.setSubTotalPrice(cardItem.getSubTotalPrice()
						+ product.getgPrice());
				// 下面计算整个购物车里面所有商品总的价格
				totalPrice += product.getgPrice();
			}
		}
		// 这种情况说明这里没有添加过这种商品（同一种）
		if (!cardItems.containsKey(product.getgId())) {
			CardItem cardItem = new CardItem();
			cardItem.setProduct(product);
			cardItem.setProductCount(1);
			cardItem.setSubTotalPrice(product.getgPrice());
			// 最终将商品添加到购物车
			cardItems.put(product.getgId(), cardItem);
		}
	}

	/**
	 * 
	 * @Title: removeCardItem
	 * @Description: 删除单个购物项的方法
	 * @param @param gId
	 * @return void
	 * @throws
	 */
	public void removeCardItem(int gId) {
		cardItems.remove(gId);
		getTotalPrice();
	}
}
