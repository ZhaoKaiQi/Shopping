package com.qf.shopping.product.dao;

import com.qf.shopping.product.entity.Product;

public interface IProductDao {
	/**
	 * 
	 * @Title: getProductById
	 * @Description: 通过产品ID获取产品的详细信息
	 * @param @param gId
	 * @param @return
	 * @return Product
	 * @throws
	 */
	Product getProductById(int gId);
}
