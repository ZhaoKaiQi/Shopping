package com.qf.shopping.user.dao;

import java.sql.SQLException;

import com.qf.shopping.user.entity.User;

public interface IUserDao {
	/**
	 * 
	 * @Title: save
	 * @Description: TODO
	 * @param @param user
	 * @return void
	 * @throws
	 */
	void save(User user);

	/**
	 * @return 
	 * 
	 * @Title: findUserNameExitOrNot
	 * @Description: ����û����Ƿ�Ϸ�
	 * @param @param user
	 * @return void
	 * @throws
	 */
	boolean findUserNameExitOrNot(User user);
	/**
	 * @throws SQLException 
	 * @param code 
	 * 
	 * @Title: findUserByCode
	 * @Description: ͨ���������ҵ��û�
	 * @param @param user
	 * @return User
	 * @throws
	 */
	User findUserByCode(String code) throws SQLException;
	/**
	 * 
	 * @Title: changeUState
	 * @Description: �ı��û�״̬
	 * @param @param user
	 * @return void
	 * @throws
	 */
	void changeUState(int getuId);
	/**
	 * 
	 * @Title: clearCode
	 * @Description: �����֤��
	 * @param @param user
	 * @return void
	 * @throws
	 */
	void clearCode(int getuId);
	/**
	 * @throws SQLException 
	 * 
	 * @Title: findPasswordByName
	 * @Description: ͨ���û�����������
	 * @param @param user
	 * @return void
	 * @throws
	 */
	User findPasswordByName(User user) throws SQLException;
	/**
	 * @throws SQLException 
	 * @Title: getUserByName
	 * @Description: ͨ���û��������û���Ϣ
	 * @param @param user
	 * @return void
	 * @throws
	 */
	User getUserByName(User user) throws SQLException;

}
