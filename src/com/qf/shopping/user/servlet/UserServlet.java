package com.qf.shopping.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.shopping.user.entity.User;
import com.qf.shopping.user.service.IUserService;
import com.qf.shopping.user.service.impl.UserService;
import com.qf.shopping.utils.MsgUtils;
import com.qf.shopping.utils.ObjUtils;

public class UserServlet extends HttpServlet {
	IUserService userService = new UserService();// ��������

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			User user = ObjUtils.getParametes(request, User.class);
			// ����ע��
			String methodName = request.getParameter("method");
			System.out.println("�������ƣ�" + methodName);
			System.out.println(user);
			// ������д���
			if ("regist".equals(methodName)) {// ˵����Ҫע��
				System.out.println("registҳ�洫�����ķ�������ִ��");
				handleRegist(user, request, response);
			} else if ("landing".equals(methodName)) {
				System.out.println("landing�������ķ�������ִ��");
				finalLanding(request, response, user);
			} else if ("checkUserName".equals(methodName)) {// �����û��ĺϷ���
				checkUserValitedAndNot(response, user);
			} else if ("giveLife".equalsIgnoreCase(methodName)) {
				handleCode(request, response);
			} else if ("checkLandingUserName".equals(methodName)) {// ˵����Ҫ��¼
				checkLandingUserValitedAndNot(response, user);
			} else if ("checkLandingPassword".equals(methodName)) {
				checkLandingpasswordRightOrWrong(request, response, user);
			}

		} catch (Exception e) {
			System.out.println("�ʼ�����ʧ�ܣ�" + e.getMessage());
		}
	}

	private void finalLanding(HttpServletRequest request,
			HttpServletResponse response, User user) throws ServletException,
			IOException, SQLException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		boolean hl=handleLanding(user, request, response);
		boolean clp=checkLandingpasswordRightOrWrong(request, response,user);
		if (hl&&clp) {
			System.out.println("����һ������Ҫ�ķ���������ִ��");
			// ˵���û��������롢��֤�롢״ֵ̬����ע�ᣩ��û����
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
		} else {//���������⣬������ת�ص�½ҳ��
			System.out.println("����һ������Ҫ�ķ���������ִ��2");
			request.getRequestDispatcher("/WEB-INF/landing.jsp")
					.forward(request, response);
		}
	}

	/**
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 * 
	 * @Title: handleLanding
	 * @Description: �����½
	 * @param @param user
	 * @param @param request
	 * @return void
	 * @throws
	 */

	private boolean handleLanding(User user, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		request.setCharacterEncoding("UTF-8");
		// ��ȡ��֤��
		String yzm = request.getParameter("yzm");
		// ��session���������ȡ����֤��
		String checkCode = (String) request.getSession().getAttribute(
				"checkcode");
		// ���ﹹ��һ����ȡustate�ķ����õ���Ӧ��״ֵ̬
		User str = userService.getUserByName(user);
		PrintWriter writer = response.getWriter();
		int uState = str.getuState();
		System.out.println("���ݿ�����֤���ustateֵ�ǣ�" + uState);
		if (yzm.equalsIgnoreCase(checkCode) && uState == 1) {
			System.out.println("ִ�е�...");
			return true;
			// ���˵���Ѿ�ע�ἤ����Ե�¼��ת����ҳ
			// ����Ӧ����ת����½��ҳ����ȥ
			// request.getRequestDispatcher("/index.do").forward(request,
			// response);
		} else {
			return false;
			// �����û���֤��������
			// request.setAttribute("checkCode",
			// "��֤��������");request.getRequestDispatcher("/WEB-INF/landing.jsp").forward(request,
			// response);
		}
		// request.getRequestDispatcher("/WEB-INF/landing.jsp").forward(request,
		// response);
	}

	/**
	 * @throws ServletException
	 * @throws SQLException
	 * @throws IOException
	 * @Title:checkLandingpasswordRightOrWrong
	 * @Description: �������������У���û������Ƿ�Ϸ���
	 * @param @param response
	 * @param @param user
	 * @param @throws IOException
	 * @return void
	 * @throws
	 */
	private boolean checkLandingpasswordRightOrWrong(
			HttpServletRequest request, HttpServletResponse response, User user)
			throws IOException, SQLException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		boolean b = userService.checkUserNameValitedOrNot(user);
		PrintWriter writer = response.getWriter();

		System.out.println("������֤�����Ƿ�Ϸ��ķ�������������");
		System.out.println(b);
		System.out.println(user.getuName());
		System.out.println(user.getuPassword());
		if (b) {
			User pwd = userService.findUserPasswordByName(user);
			System.out.println("���ݿ��м�¼�������ǣ�" + pwd.getuPassword());
			if (!(user.getuPassword()).equals(pwd.getuPassword())) {
				// �û������ڵ������У�����ݿ��е���Ӧ�����Ƿ��ҳ�洫������һ��
				writer.write("<font color='red'>�������</font>");
				return false;
			} else {
				writer.write("<font color='green'>������ȷ</font>");
				return true;
			}
		} else {
			// �û��������ڵ�����£�ֱ��������û������ڡ���OK
			writer.write("<font color='red'>�û�������</font>");
			return false;
		}
		// writer.flush();
		// writer.close();

	}

	/**
	 * @Title: checkLandingUserValitedAndNot
	 * @Description: �������������У���û����Ƿ�Ϸ���
	 * @param @param response
	 * @param @param user
	 * @param @throws IOException
	 * @return void
	 * @throws
	 */
	private void checkLandingUserValitedAndNot(HttpServletResponse response,
			User user) throws ServletException, IOException {
		// ʵ�ʿ�������������̨У��
		boolean b = userService.checkUserNameValitedOrNot(user);
		// ���Ƿ��ز��Ϸ�������
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		if (!b) {
			// д����
			writer.write("<font color='red'>�û�������</font>");
		} else {
			// д����
			writer.write("<font color='green'>���û��Ϸ�</font>");
		}
		writer.flush();
		writer.close();
	}

	/**
	 * @throws SQLException
	 * 
	 * @Title: handleCode
	 * @Description: �������������������֤���
	 * @param @param response
	 * @param @param user
	 * @param @throws IOException
	 * @return void
	 * @throws
	 */
	private void handleCode(HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		String str = request.getParameter("code");
		System.out.println("�û�������������˻���ִ����UserServlet�е�handleCode������");
		// ��ѯ���ݿ������֤���Ƿ���ڣ�������ڵĻ������û���״̬���ó�1
		User user = userService.checkCodeExitOrNot(str);
		// �ж�
		if (user != null) {
			// �ı�
			userService.changeuState(user.getuId());
			// ���״̬��
			userService.clearCode(user.getuId());

		}
	}

	/**
	 * 
	 * @Title: checkUserValitedAndNot
	 * @Description: ����û����Ƿ�Ϸ�
	 * @param @param response
	 * @param @param user
	 * @param @throws IOException
	 * @return void
	 * @throws
	 */
	private void checkUserValitedAndNot(HttpServletResponse response, User user)
			throws IOException {
		boolean b = userService.checkUserNameValitedOrNot(user);
		// ���Ƿ��ز��Ϸ�������
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		if (b) {
			// д����
			writer.write("<font color='red'>�û��Ѿ�������</font>");
		} else {
			// д����
			writer.write("<font color='green'>�û����ǺϷ���</font>");
		}
		writer.flush();
		writer.close();
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * 
	 * @Title: handleRegist
	 * @Description: ����ע��
	 * @param @param user
	 * @param @param request
	 * @return void
	 * @throws
	 */
	private void handleRegist(User user, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ��֤��
		String yzm = request.getParameter("yzm");
		// ��session���������ȡ����֤��
		String checkCode = (String) request.getSession().getAttribute(
				"checkcode");
		if (yzm.equalsIgnoreCase(checkCode)) {
			// ʵ�ʿ�������������̨У��
			boolean b = userService.checkUserNameValitedOrNot(user);
			if (!b) {
				// ����û�ע��
				user.setuCode(UUID.randomUUID().toString().replace("-", ""));// ͨ��UUID�������û�����ֵ
				user.setuState(0);
				userService.regist(user);
				// ������Ҫ��ͻ��˷����ʼ�
				try {
					MsgUtils.sendMsg("boy@qiqi.com", user.getuCode());
				} catch (Exception e) {
					throw new RuntimeException("�ʼ����ͳ����쳣��" + e);
				}
				// ����Ӧ����ת��ע��ɹ���ҳ����ȥ
				request.getRequestDispatcher("/WEB-INF/zhucexiangxi.jsp")
						.forward(request, response);
			}
		} else {
			// �����û���֤��������
			request.setAttribute("checkCode", "��֤��������");
			request.getRequestDispatcher("/WEB-INF/regist.jsp").forward(
					request, response);

		}

	}
}
