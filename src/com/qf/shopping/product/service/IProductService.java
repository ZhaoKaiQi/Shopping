package com.qf.shopping.product.service;

import com.qf.shopping.product.entity.Product;

/**
 * 产品业务逻辑层的接口
 * 
 * @ClassName: IProductService
 * @author 赵凯琦
 * @date 2017-5-26 上午1:33:50
 * 
 */
public interface IProductService {
	Product getProductById(int gId);
}
