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
 * �����Ŀ��Ʋ�
 * 
 * @ClassName: OrderServlet
 * @author �Կ���
 * @date 2017-5-27 ����1:24:34
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
			// �Ѷ�����Ϣȫ����ɢ����������
			String method = request.getParameter("method");
			System.out.println("�������еķ���ִ����");
			if ("addOrder".equals(method)) {
				handleAddOrder(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("����������쳣" + e.getMessage());
		}
	}

	/**
	 * @throws Exception
	 * 
	 * @Title: handleAddOrder
	 * @Description: ���ﳵ���涩����Ϣ
	 * @param @param request
	 * @param @param response
	 * @return void
	 * @throws
	 */
	private void handleAddOrder(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("�������б��涩����Ϣ�ķ���ִ���ˣ�servlet��74��");
		// ����Ӧ�ñ������ݵ������
		Card card = (Card) request.getSession().getAttribute("card");// ��ȡ���ﳵ
		saveOrder(card);
		// �����ѯ��ǰ�������ݵ�id
		int oId = orderService.getGenerateKey();
		System.out.println("������id�ǣ�" + oId);
		// ά������ı�
		saveOrderDetail(card, oId);
		// ��ȡ�Ǹ���������ֵ
		int oDId = orderDetailService.getGenarateKey();
		System.out.println("�����oDId��ֵ�ǣ�"+oDId);
		// ά����ϵ��
		saveGoodAndOrderDetail(card, oDId);
		//��ת��ҳ��
		request.getRequestDispatcher("/WEB-INF/address.jsp").forward(request, response);
	}

	/**
	 * 
	 * @Title: saveGoodAndOrderDetail
	 * @Description: ά����ϵ��
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
			// ����ķ���
			orderDetailAndGoodService.addRelation(orderDetailAndGood);
		}
	}

	/**
	 * @throws SQLException
	 * 
	 * @Title: saveOrderDetail
	 * @Description: ά����������
	 * @param @param card
	 * @return void
	 * @throws
	 */
	private void saveOrderDetail(Card card, int oId) throws SQLException {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setoId(oId);
		// ���յ��ñ���ķ���
		orderDetailService.addOrderDetail(orderDetail);
	}

	/**
	 * @throws Exception
	 * 
	 * @Title: saveOrder
	 * @Description: ���涩����Ϣ��������
	 * @param @param card
	 * @return void
	 * @throws
	 */
	private void saveOrder(Card card) throws Exception {
		// ���濪ʼ��װ����
		Order order = new Order();
		order.setoState(0);
		order.setoTime(new Date());
		order.setoTotalPrice(card.getTotalPrice());
		order.setuId(1);// ����ط�Ҫ��������������ݣ��Ժ󻹵ø�
		// �������ʵ�ַ���
		orderService.addOrder(order);
	}

}
