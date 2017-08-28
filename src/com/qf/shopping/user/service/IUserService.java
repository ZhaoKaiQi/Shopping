package com.qf.shopping.user.service;

import java.sql.SQLException;

import com.qf.shopping.user.entity.User;

public interface IUserService {
	/**
	 * 
	 * @Title: regist
	 * @Description:ע��
	 * @param @param user
	 * @return void
	 * @throws
	 */
	void regist(User user);

	/**
	 * @return
	 * 
	 * @Title: checkUserNameValitedOrNot
	 * @Description: ����û�������д�Ƿ�������
	 * @param @param user
	 * @return void
	 * @throws
	 */
	boolean checkUserNameValitedOrNot(User user);

	/**
	 * @throws SQLException
	 * 
	 * @Title: checkCodeExitOrNot
	 * @Description:������֤���Ƿ���ڵķ��������������ô�����û�
	 * @param @param user
	 * @return User
	 * @throws
	 */
	User checkCodeExitOrNot(String str) throws SQLException;

	/**
	 * @throws SQLException
	 * 
	 * @Title: changeuState
	 * @Description:�ı�����ֵ
	 * @param @param user
	 * @return User
	 * @throws
	 */
	void changeuState(int getuId);

	/**
	 * @throws SQLException
	 * 
	 * @Title: clearCode
	 * @Description:���
	 * @param @param user
	 * @return User
	 * @throws
	 */
	void clearCode(int getuId);

	/**
	 * @throws SQLException
	 * @param user
	 * 
	 * @Title: findUserPasswordByName
	 * @Description:ͨ���û��������û�����
	 * @param @param user
	 * @return User
	 * @throws
	 */
	User findUserPasswordByName(User user) throws SQLException;

	/**
	 * @throws SQLException
	 * 
	 * @Title: getUserByName
	 * @Description:ͨ���û��������û���Ϣ
	 * @param @param user
	 * @return void
	 * @throws
	 */
	User getUserByName(User user) throws SQLException;

}
