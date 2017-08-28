package com.qf.shopping.card.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.shopping.card.entity.Card;
import com.qf.shopping.product.entity.Product;
import com.qf.shopping.product.service.IProductService;
import com.qf.shopping.product.service.impl.ProductService;

/**
 * 购物车的控制层
 * 
 * @ClassName: CardServlet
 * @author 赵凯琦
 * @date 2017-5-26 上午4:23:52
 * 
 */
public class CardServlet extends HttpServlet {
	IProductService productService = new ProductService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String method = request.getParameter("method");
			if ("addCard".contains(method)) {
				// 添加商品到购物车
				handleAdd(request, response);
			} else if ("remove".equals(method)) {
				// 说明执行了删除购物车的方法
				handleRemove(request, response);
			}

		} catch (Exception e) {
			throw new RuntimeException("添加商品出问题了（servlet）");
		}
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * 
	 * @Title: handleRemove
	 * @Description: 删除购物车中的购物项
	 * @param @param request
	 * @param @param response
	 * @return void
	 * @throws
	 */
	private void handleRemove(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String gIdStr = request.getParameter("gId");
		// 获取购物车
		Card card = getCard(request);
		card.removeCardItem(Integer.parseInt(gIdStr));
		// 跳转页面
		request.getRequestDispatcher("/WEB-INF/gouwuche.jsp").forward(request,
				response);
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * 
	 * @Title: handleAdd
	 * @Description: 添加商品的方法
	 * @param @param request
	 * @return void
	 * @throws
	 */
	private void handleAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取Id
		String gIdStr = request.getParameter("gId");
		// 下面要查找商品的东西
		Product product = productService.getProductById(Integer
				.parseInt(gIdStr));
		if (product != null) {
			// 说明查询到了商品，那么将商品添加到域对象中
			Card card = getCard(request);
			// 调用购物车中添加的方法
			card.addCard(product);
			// 跳转到购物车这个页面
			request.getRequestDispatcher("/WEB-INF/gouwuche.jsp").forward(
					request, response);
		}
	}

	/**
	 * @return
	 * 
	 * @Title: getCard
	 * @Description: 获取购物车这个对象的方法
	 * @param
	 * @return void
	 * @throws
	 */
	private Card getCard(HttpServletRequest request) {
		Card card = (Card) request.getSession().getAttribute("card");
		if (card != null) {
			// 执行到这里说明已经添加过商品了
			return card;
		} else {
			Card card2 = new Card();
			request.getSession().setAttribute("card", card2);
		}
		return (Card) request.getSession().getAttribute("card");
	}

}
