package com.qf.shopping.product.service.impl;

import com.qf.shopping.product.dao.IProductDao;
import com.qf.shopping.product.dao.impl.ProductDao;
import com.qf.shopping.product.entity.Product;
import com.qf.shopping.product.service.IProductService;

/**
 * 商品业务逻辑层的实现类
 * 
 * @ClassName: ProductService
 * @author 赵凯琦
 * @date 2017-5-26 上午1:37:59
 * 
 */
public class ProductService implements IProductService {
	IProductDao productDao = new ProductDao();

	@Override
	public Product getProductById(int gId) {
		if (gId <= 0) {
			throw new RuntimeException("商品的Id不合法");
		}
		return productDao.getProductById(gId);
	}

}
