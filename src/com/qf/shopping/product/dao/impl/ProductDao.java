package com.qf.shopping.product.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.shopping.product.dao.IProductDao;
import com.qf.shopping.product.entity.Product;
import com.qf.shopping.utils.JDBCUtils;

/**
 * ��ƷDao��ʵ��
 * 
 * @ClassName: ProductDao
 * @author �Կ���
 * @date 2017-5-26 ����1:20:34
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
			System.out.println("����ID��ȡ��Ʒ��Ϣ�����쳣");
		}
		return null;
	}

}
