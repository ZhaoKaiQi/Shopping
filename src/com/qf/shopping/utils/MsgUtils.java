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
 * @Description: ����һ�������ʼ��İ�����
 * @author �Կ���
 * @date 2017-5-20 ����1:11:28
 * 
 */
public class MsgUtils {
	/**
	 * @throws MessagingException
	 * @throws AddressException
	 * 
	 * @Title: getQueryRunner
	 * @Description: ��һ�������������﷢�ͣ��ڶ������������͵�������ʲô
	 * @param @return
	 * @return QueryRunner
	 * @throws
	 */
	public static void sendMsg(String to, String code) throws AddressException,
			MessagingException {
		// �����ʼ�����ҲҪ��ȡSession�������������mail�����
		/*
		 * ��һ����������������Ϣ �ʼ��������ĵ�ַ �Ƿ�ʹ�õ��� �ʼ��������Ķ˿� �ڶ���������ͨ���û��������������֤����֤��
		 */
		Properties props = new Properties();
		props.setProperty("mail.host", "localhost");//ȷ�����Ƿ����ʼ�������
		props.setProperty("mail.debug", "true");
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// �����ߵ��û���������
				return new PasswordAuthentication("boy@qiqi.com", "123");//�������������setFromһ��
			}
		});
		// ��ȡ�ʼ�����
		Message message = new MimeMessage(session);
		// ���÷�����
		message.setFrom(new InternetAddress("boy@qiqi.com"));
		// ���ý�����
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		// �����ʼ��ı���
		message.setSubject("�����̳�ע���û������ʼ�");
		// �����ʼ�����
		message.setSentDate(new Date());
		// "<h1>���������̳�Ψһ�ķ��������뼤���û�:"+request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + request.getServletPath() + "user.do?method=giveLife&amp;code="+ code + "</h1>"
		message.setContent("<h1>���������̳�Ψһ�ķ��������뼤���û�:http://10.7.184.138:8080/Shopping/user.do?method=giveLife&amp;code="+ code + "</h1>", "text/html;charset=utf-8");
		// �����ʼ�
		Transport.send(message);
	}
}
