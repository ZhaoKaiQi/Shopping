package com.qf.shopping.order.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.shopping.card.entity.Card;
import com.qf.shopping.card.entity.CardItem;
import com.qf.shopping.order.entity.Order;
import com.qf.shopping.order.entity.OrderDetail;
import com.qf.shopping.order.entity.OrderDetailAndGood;
import com.qf.shopping.order.service.IOrderDetailAndGoodService;
import com.qf.shopping.order.service.IOrderDetailService;
import com.qf.shopping.order.service.IOrderService;
import com.qf.shopping.order.service.impl.OrderDetailAndGoodService;
import com.qf.shopping.order.service.impl.OrderDetailService;
import com.qf.shopping.order.service.impl.OrderService;

/**
 * 订单的控制层
 * 
 * @ClassName: OrderServlet
 * @author 赵凯琦
 * @date 2017-5-27 上午1:24:34
 * 
 */
public class OrderServlet extends HttpServlet {
	IOrderService orderService = new OrderService();
	IOrderDetailService orderDetailService = new OrderDetailService();
	IOrderDetailAndGoodService orderDetailAndGoodService = new OrderDetailAndGoodService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 把订单信息全部分散到三个表中
			String method = request.getParameter("method");
			System.out.println("订单表中的方法执行了");
			if ("addOrder".equals(method)) {
				handleAddOrder(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("订单表出现异常" + e.getMessage());
		}
	}

	/**
	 * @throws Exception
	 * 
	 * @Title: handleAddOrder
	 * @Description: 购物车保存订单信息
	 * @param @param request
	 * @param @param response
	 * @return void
	 * @throws
	 */
	private void handleAddOrder(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("订单表中保存订单信息的方法执行了，servlet第74行");
		// 这里应该保存数据到域对象
		Card card = (Card) request.getSession().getAttribute("card");// 获取购物车
		saveOrder(card);
		// 下面查询当前插入数据的id
		int oId = orderService.getGenerateKey();
		System.out.println("订单的id是：" + oId);
		// 维护详情的表
		saveOrderDetail(card, oId);
		// 获取那个自增长的值
		int oDId = orderDetailService.getGenarateKey();
		System.out.println("这里的oDId的值是："+oDId);
		// 维护关系表
		saveGoodAndOrderDetail(card, oDId);
		//跳转到页面
		request.getRequestDispatcher("/WEB-INF/address.jsp").forward(request, response);
	}

	/**
	 * 
	 * @Title: saveGoodAndOrderDetail
	 * @Description: 维护关系表
	 * @param @param card
	 * @param @param oId
	 * @return void
	 * @throws
	 */
	private void saveGoodAndOrderDetail(Card card, int oDId) {
		Collection<CardItem> cardItems2 = card.getCardItems2();
		for (CardItem cardItem : cardItems2) {
			OrderDetailAndGood orderDetailAndGood = new OrderDetailAndGood();
			orderDetailAndGood.setgId(cardItem.getProduct().getgId());
			orderDetailAndGood.setoDId(oDId);
			// 保存的方法
			orderDetailAndGoodService.addRelation(orderDetailAndGood);
		}
	}

	/**
	 * @throws SQLException
	 * 
	 * @Title: saveOrderDetail
	 * @Description: 维护订单详情
	 * @param @param card
	 * @return void
	 * @throws
	 */
	private void saveOrderDetail(Card card, int oId) throws SQLException {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setoId(oId);
		// 最终调用保存的方法
		orderDetailService.addOrderDetail(orderDetail);
	}

	/**
	 * @throws Exception
	 * 
	 * @Title: saveOrder
	 * @Description: 保存订单信息到订单表
	 * @param @param card
	 * @return void
	 * @throws
	 */
	private void saveOrder(Card card) throws Exception {
		// 下面开始组装数据
		Order order = new Order();
		order.setoState(0);
		order.setoTime(new Date());
		order.setoTotalPrice(card.getTotalPrice());
		order.setuId(1);// 这个地方要从域对象中拿数据，以后还得改
		// 下面调用实现方法
		orderService.addOrder(order);
	}

}
