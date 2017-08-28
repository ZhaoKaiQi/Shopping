package com.qf.shopping.product.dao;

import com.qf.shopping.product.entity.Product;

public interface IProductDao {
	/**
	 * 
	 * @Title: getProductById
	 * @Description: ͨ����ƷID��ȡ��Ʒ����ϸ��Ϣ
	 * @param @param gId
	 * @param @return
	 * @return Product
	 * @throws
	 */
	Product getProductById(int gId);
}
