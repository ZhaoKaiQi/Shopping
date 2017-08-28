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
	// ����Ӧ��ά����Ʒ��service����
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
				System.out.println("ִ�е�������");
			} else if ("landing".equals(method)) {
				request.getRequestDispatcher("/WEB-INF/landing.jsp").forward(
						request, response);
			} else if ("getProductById".equals(method)) {
				// ��ʾ����ҳͨ��Id����ȡ��Ʒ��Ϣ
				handleGetProductById(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/index.jsp").forward(
						request, response);
			}
		} catch (Exception e) {
			System.out.println("�����������������");
		}
	}

	/**
	 * 
	 * @Title: handleGetProductById
	 * @Description: ͨ��Id��ȡ��Ʒ��Ϣ
	 * @param @param request
	 * @param @param response
	 * @return void
	 * @throws
	 */
	private void handleGetProductById(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// ��һ������ȡ��ƷId
		String gIdStr = request.getParameter("gId");
		Product product = productService.getProductById(Integer
				.parseInt(gIdStr));
		// �ڶ����������쳣
		if (product != null) {
			// ˵����ѯ���ݿ���û�������
			// �����ݷ����������
			request.setAttribute("product", product);
			// ����ҳ�����ת
			request.getRequestDispatcher("/WEB-INF/shopping.jsp").forward(
					request, response);
		}
		// ���û������Ҳû�����쳣��˵��¼����������������

	}

}
