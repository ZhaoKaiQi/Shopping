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
 * ���ﳵ�Ŀ��Ʋ�
 * 
 * @ClassName: CardServlet
 * @author �Կ���
 * @date 2017-5-26 ����4:23:52
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
				// �����Ʒ�����ﳵ
				handleAdd(request, response);
			} else if ("remove".equals(method)) {
				// ˵��ִ����ɾ�����ﳵ�ķ���
				handleRemove(request, response);
			}

		} catch (Exception e) {
			throw new RuntimeException("�����Ʒ�������ˣ�servlet��");
		}
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * 
	 * @Title: handleRemove
	 * @Description: ɾ�����ﳵ�еĹ�����
	 * @param @param request
	 * @param @param response
	 * @return void
	 * @throws
	 */
	private void handleRemove(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String gIdStr = request.getParameter("gId");
		// ��ȡ���ﳵ
		Card card = getCard(request);
		card.removeCardItem(Integer.parseInt(gIdStr));
		// ��תҳ��
		request.getRequestDispatcher("/WEB-INF/gouwuche.jsp").forward(request,
				response);
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * 
	 * @Title: handleAdd
	 * @Description: �����Ʒ�ķ���
	 * @param @param request
	 * @return void
	 * @throws
	 */
	private void handleAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��ȡId
		String gIdStr = request.getParameter("gId");
		// ����Ҫ������Ʒ�Ķ���
		Product product = productService.getProductById(Integer
				.parseInt(gIdStr));
		if (product != null) {
			// ˵����ѯ������Ʒ����ô����Ʒ��ӵ��������
			Card card = getCard(request);
			// ���ù��ﳵ����ӵķ���
			card.addCard(product);
			// ��ת�����ﳵ���ҳ��
			request.getRequestDispatcher("/WEB-INF/gouwuche.jsp").forward(
					request, response);
		}
	}

	/**
	 * @return
	 * 
	 * @Title: getCard
	 * @Description: ��ȡ���ﳵ�������ķ���
	 * @param
	 * @return void
	 * @throws
	 */
	private Card getCard(HttpServletRequest request) {
		Card card = (Card) request.getSession().getAttribute("card");
		if (card != null) {
			// ִ�е�����˵���Ѿ���ӹ���Ʒ��
			return card;
		} else {
			Card card2 = new Card();
			request.getSession().setAttribute("card", card2);
		}
		return (Card) request.getSession().getAttribute("card");
	}

}
