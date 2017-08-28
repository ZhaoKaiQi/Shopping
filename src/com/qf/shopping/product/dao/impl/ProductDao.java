package com.qf.shopping.product.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.shopping.product.dao.IProductDao;
import com.qf.shopping.product.entity.Product;
import com.qf.shopping.utils.JDBCUtils;

/**
 * 产品Dao的实现
 * 
 * @ClassName: ProductDao
 * @author 赵凯琦
 * @date 2017-5-26 上午1:20:34
 * 
 */
public class ProductDao implements IProductDao {

	@Override
	public Product getProductById(int gId) {
		QueryRunner runner = JDBCUtils.getQueryRunner();
		String sql = "select * from t_good where gId=?";
		try {
			Product product = runner.query(sql, new BeanHandler<Product>(
					Product.class), gId);
			if (product != null) {
				return product;
			}
		} catch (SQLException e) {
			System.out.println("根据ID获取货品信息出现异常");
		}
		return null;
	}

}
