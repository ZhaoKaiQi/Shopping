package com.qf.shopping.card.entity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.qf.shopping.product.entity.Product;

/**
 * ���ﳵ������� ,���������ﳵ�Ķ�����Ϊֻ��ҵ���߼���򽻵��ģ����Բ���ҪдDao��(Dao���������������ݿ��)
 * 
 * @ClassName: Card
 * @author �Կ���
 * @date 2017-5-26 ����3:31:09
 * 
 */
public class Card {
	// ���������ά���Ĺ�����
	private Map<Integer, CardItem> cardItems = new LinkedHashMap<Integer, CardItem>();
	// ά���ܵļ۸�
	private float totalPrice = 0;
	// ��ά��һ�����ԣ����������Ҫ�������浥�����ϵĹ�����
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
	 * @Description: ��ȡ������Ʒ�۸���ܺ�
	 * @param @return
	 * @return float
	 * @throws
	 */
	public float getTotalPrice() {
		// ����ط�Ҫ������ܵļ۸�
		Collection<CardItem> values = cardItems.values();
		for (CardItem cardItem : values) {
			totalPrice += cardItem.getSubTotalPrice();
		}
		return totalPrice;
	}

	/**
	 * 
	 * @Title: clearCard
	 * @Description: ��չ��ﳵ�ķ���
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
	 * @Description: ������ݵ����ﳵ�ķ���
	 * @param @param product
	 * @return void
	 * @throws
	 */
	public void addCard(Product product) {
		// �жϹ��ﳵ���Ƿ��������Ʒ��
		Set<Integer> keySet = cardItems.keySet();
		for (Integer gId : keySet) {
			if (product.getgId() == gId) {
				// ˵�������Ʒ�Ѿ��ڹ��ﳵ���ˣ�ֻ��Ҫ������һ�Ϳ�����
				// ȡ�������Ʒ���ڵĹ�����
				CardItem cardItem = cardItems.get(gId);
				// ������������һ�ͼ۸�仯������
				cardItem.setProductCount(cardItem.getProductCount() + 1);
				// �ı䵥����Ʒ�۸�
				cardItem.setSubTotalPrice(cardItem.getSubTotalPrice()
						+ product.getgPrice());
				// ��������������ﳵ����������Ʒ�ܵļ۸�
				totalPrice += product.getgPrice();
			}
		}
		// �������˵������û����ӹ�������Ʒ��ͬһ�֣�
		if (!cardItems.containsKey(product.getgId())) {
			CardItem cardItem = new CardItem();
			cardItem.setProduct(product);
			cardItem.setProductCount(1);
			cardItem.setSubTotalPrice(product.getgPrice());
			// ���ս���Ʒ��ӵ����ﳵ
			cardItems.put(product.getgId(), cardItem);
		}
	}

	/**
	 * 
	 * @Title: removeCardItem
	 * @Description: ɾ������������ķ���
	 * @param @param gId
	 * @return void
	 * @throws
	 */
	public void removeCardItem(int gId) {
		cardItems.remove(gId);
		getTotalPrice();
	}
}
