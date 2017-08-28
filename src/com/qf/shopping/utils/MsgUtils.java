package com.qf.shopping.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @ClassName: MsgUtils
 * @Description: 这是一个发送邮件的帮助类
 * @author 赵凯琦
 * @date 2017-5-20 上午1:11:28
 * 
 */
public class MsgUtils {
	/**
	 * @throws MessagingException
	 * @throws AddressException
	 * 
	 * @Title: getQueryRunner
	 * @Description: 第一个参数：往哪里发送；第二个参数：发送的内容是什么
	 * @param @return
	 * @return QueryRunner
	 * @throws
	 */
	public static void sendMsg(String to, String code) throws AddressException,
			MessagingException {
		// 发送邮件首先也要获取Session对象这个对象是mail包里的
		/*
		 * 第一个参数：是配置信息 邮件服务器的地址 是否使用调试 邮件服务器的端口 第二个参数是通过用户名和密码进行认证的认证器
		 */
		Properties props = new Properties();
		props.setProperty("mail.host", "localhost");//确定的是发送邮件的主机
		props.setProperty("mail.debug", "true");
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// 发送者的用户名和密码
				return new PasswordAuthentication("boy@qiqi.com", "123");//这里必须和下面的setFrom一致
			}
		});
		// 获取邮件对象
		Message message = new MimeMessage(session);
		// 设置发送者
		message.setFrom(new InternetAddress("boy@qiqi.com"));
		// 设置接收者
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		// 设置邮件的标题
		message.setSubject("美邦商城注册用户激活邮件");
		// 设置邮件内容
		message.setSentDate(new Date());
		// "<h1>请点击美邦商城唯一的方法激活码激活用户:"+request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + request.getServletPath() + "user.do?method=giveLife&amp;code="+ code + "</h1>"
		message.setContent("<h1>请点击美邦商城唯一的方法激活码激活用户:http://10.7.184.138:8080/Shopping/user.do?method=giveLife&amp;code="+ code + "</h1>", "text/html;charset=utf-8");
		// 发送邮件
		Transport.send(message);
	}
}
