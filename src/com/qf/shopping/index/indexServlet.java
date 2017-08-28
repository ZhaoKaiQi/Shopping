package com.qf.shopping.index;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.shopping.product.entity.Product;
import com.qf.shopping.product.service.IProductService;
import com.qf.shopping.product.service.impl.ProductService;

public class indexServlet extends HttpServlet {
	// 这里应该维护商品的service对象
	IProductService productService = new ProductService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		try {
			if ("regist".equals(method)) {
				request.getRequestDispatcher("/WEB-INF/regist.jsp").forward(
						request, response);
				System.out.println("执行到了这里");
			} else if ("landing".equals(method)) {
				request.getRequestDispatcher("/WEB-INF/landing.jsp").forward(
						request, response);
			} else if ("getProductById".equals(method)) {
				// 表示在首页通过Id来获取商品信息
				handleGetProductById(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/index.jsp").forward(
						request, response);
			}
		} catch (Exception e) {
			System.out.println("处理请求出现了问题");
		}
	}

	/**
	 * 
	 * @Title: handleGetProductById
	 * @Description: 通过Id获取产品信息
	 * @param @param request
	 * @param @param response
	 * @return void
	 * @throws
	 */
	private void handleGetProductById(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 第一步：获取商品Id
		String gIdStr = request.getParameter("gId");
		Product product = productService.getProductById(Integer
				.parseInt(gIdStr));
		// 第二步：捕获异常
		if (product != null) {
			// 说明查询数据库是没有问题的
			// 将数据放入域对象中
			request.setAttribute("product", product);
			// 进行页面的跳转
			request.getRequestDispatcher("/WEB-INF/shopping.jsp").forward(
					request, response);
		}
		// 如果没有数据也没出现异常，说明录入的数据是有问题的

	}

}
