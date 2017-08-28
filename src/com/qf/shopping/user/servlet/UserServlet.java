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
	IUserService userService = new UserService();// 声明变量

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			User user = ObjUtils.getParametes(request, User.class);
			// 进行注册
			String methodName = request.getParameter("method");
			System.out.println("方法名称：" + methodName);
			System.out.println(user);
			// 下面进行处理
			if ("regist".equals(methodName)) {// 说明需要注册
				System.out.println("regist页面传过来的方法可以执行");
				handleRegist(user, request, response);
			} else if ("landing".equals(methodName)) {
				System.out.println("landing传过来的方法可以执行");
				finalLanding(request, response, user);
			} else if ("checkUserName".equals(methodName)) {// 检验用户的合法性
				checkUserValitedAndNot(response, user);
			} else if ("giveLife".equalsIgnoreCase(methodName)) {
				handleCode(request, response);
			} else if ("checkLandingUserName".equals(methodName)) {// 说明需要登录
				checkLandingUserValitedAndNot(response, user);
			} else if ("checkLandingPassword".equals(methodName)) {
				checkLandingpasswordRightOrWrong(request, response, user);
			}

		} catch (Exception e) {
			System.out.println("邮件发送失败：" + e.getMessage());
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
			System.out.println("这是一个很重要的方法，必须执行");
			// 说明用户名、密码、验证码、状态值（已注册）都没问题
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
		} else {//这里有问题，所以跳转回登陆页面
			System.out.println("这是一个很重要的方法，必须执行2");
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
	 * @Description: 处理登陆
	 * @param @param user
	 * @param @param request
	 * @return void
	 * @throws
	 */

	private boolean handleLanding(User user, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		request.setCharacterEncoding("UTF-8");
		// 获取验证码
		String yzm = request.getParameter("yzm");
		// 从session的域对象中取出验证码
		String checkCode = (String) request.getSession().getAttribute(
				"checkcode");
		// 这里构造一个获取ustate的方法得到对应的状态值
		User str = userService.getUserByName(user);
		PrintWriter writer = response.getWriter();
		int uState = str.getuState();
		System.out.println("数据库中验证码的ustate值是：" + uState);
		if (yzm.equalsIgnoreCase(checkCode) && uState == 1) {
			System.out.println("执行到...");
			return true;
			// 这就说明已经注册激活可以登录跳转到主页
			// 下面应该跳转到登陆的页面中去
			// request.getRequestDispatcher("/index.do").forward(request,
			// response);
		} else {
			return false;
			// 告诉用户验证码有问题
			// request.setAttribute("checkCode",
			// "验证码有问题");request.getRequestDispatcher("/WEB-INF/landing.jsp").forward(request,
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
	 * @Description: 这个方法是用来校验用户密码是否合法的
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

		System.out.println("我是验证密码是否合法的方法，哈哈哈哈");
		System.out.println(b);
		System.out.println(user.getuName());
		System.out.println(user.getuPassword());
		if (b) {
			User pwd = userService.findUserPasswordByName(user);
			System.out.println("数据库中记录的密码是：" + pwd.getuPassword());
			if (!(user.getuPassword()).equals(pwd.getuPassword())) {
				// 用户名存在的情况，校验数据库中的相应密码是否和页面传进来的一样
				writer.write("<font color='red'>密码错误</font>");
				return false;
			} else {
				writer.write("<font color='green'>密码正确</font>");
				return true;
			}
		} else {
			// 用户名不存在的情况下，直接输出“用户不存在”就OK
			writer.write("<font color='red'>用户不存在</font>");
			return false;
		}
		// writer.flush();
		// writer.close();

	}

	/**
	 * @Title: checkLandingUserValitedAndNot
	 * @Description: 这个方法是用来校验用户名是否合法的
	 * @param @param response
	 * @param @param user
	 * @param @throws IOException
	 * @return void
	 * @throws
	 */
	private void checkLandingUserValitedAndNot(HttpServletResponse response,
			User user) throws ServletException, IOException {
		// 实际开发中首先做后台校验
		boolean b = userService.checkUserNameValitedOrNot(user);
		// 我们返回不合法的数据
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		if (!b) {
			// 写数据
			writer.write("<font color='red'>用户不存在</font>");
		} else {
			// 写数据
			writer.write("<font color='green'>该用户合法</font>");
		}
		writer.flush();
		writer.close();
	}

	/**
	 * @throws SQLException
	 * 
	 * @Title: handleCode
	 * @Description: 这个方法是用来激活验证码的
	 * @param @param response
	 * @param @param user
	 * @param @throws IOException
	 * @return void
	 * @throws
	 */
	private void handleCode(HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		String str = request.getParameter("code");
		System.out.println("用户点击并激活了账户，执行了UserServlet中的handleCode方法！");
		// 查询数据库这个验证码是否存在，如果存在的话，将用户的状态设置成1
		User user = userService.checkCodeExitOrNot(str);
		// 判断
		if (user != null) {
			// 改变
			userService.changeuState(user.getuId());
			// 清空状态码
			userService.clearCode(user.getuId());

		}
	}

	/**
	 * 
	 * @Title: checkUserValitedAndNot
	 * @Description: 检测用户名是否合法
	 * @param @param response
	 * @param @param user
	 * @param @throws IOException
	 * @return void
	 * @throws
	 */
	private void checkUserValitedAndNot(HttpServletResponse response, User user)
			throws IOException {
		boolean b = userService.checkUserNameValitedOrNot(user);
		// 我们返回不合法的数据
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		if (b) {
			// 写数据
			writer.write("<font color='red'>用户已经存在了</font>");
		} else {
			// 写数据
			writer.write("<font color='green'>用户名是合法的</font>");
		}
		writer.flush();
		writer.close();
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * 
	 * @Title: handleRegist
	 * @Description: 处理注册
	 * @param @param user
	 * @param @param request
	 * @return void
	 * @throws
	 */
	private void handleRegist(User user, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取验证码
		String yzm = request.getParameter("yzm");
		// 从session的域对象中取出验证码
		String checkCode = (String) request.getSession().getAttribute(
				"checkcode");
		if (yzm.equalsIgnoreCase(checkCode)) {
			// 实际开发中首先做后台校验
			boolean b = userService.checkUserNameValitedOrNot(user);
			if (!b) {
				// 如果用户注册
				user.setuCode(UUID.randomUUID().toString().replace("-", ""));// 通过UUID来生成用户的码值
				user.setuState(0);
				userService.regist(user);
				// 这里需要向客户端发送邮件
				try {
					MsgUtils.sendMsg("boy@qiqi.com", user.getuCode());
				} catch (Exception e) {
					throw new RuntimeException("邮件发送出现异常：" + e);
				}
				// 下面应该跳转到注册成功的页面中去
				request.getRequestDispatcher("/WEB-INF/zhucexiangxi.jsp")
						.forward(request, response);
			}
		} else {
			// 告诉用户验证码有问题
			request.setAttribute("checkCode", "验证码有问题");
			request.getRequestDispatcher("/WEB-INF/regist.jsp").forward(
					request, response);

		}

	}
}
