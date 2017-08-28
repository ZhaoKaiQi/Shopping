package com.qf.shopping.product.service.impl;

import com.qf.shopping.product.dao.IProductDao;
import com.qf.shopping.product.dao.impl.ProductDao;
import com.qf.shopping.product.entity.Product;
import com.qf.shopping.product.service.IProductService;

/**
 * ��Ʒҵ���߼����ʵ����
 * 
 * @ClassName: ProductService
 * @author �Կ���
 * @date 2017-5-26 ����1:37:59
 * 
 */
public class ProductService implements IProductService {
	IProductDao productDao = new ProductDao();

	@Override
	public Product getProductById(int gId) {
		if (gId <= 0) {
			throw new RuntimeException("��Ʒ��Id���Ϸ�");
		}
		return productDao.getProductById(gId);
	}

}
