package com.qf.shopping.user.service;

import java.sql.SQLException;

import com.qf.shopping.user.entity.User;

public interface IUserService {
	/**
	 * 
	 * @Title: regist
	 * @Description:注册
	 * @param @param user
	 * @return void
	 * @throws
	 */
	void regist(User user);

	/**
	 * @return
	 * 
	 * @Title: checkUserNameValitedOrNot
	 * @Description: 检测用户名的书写是否有问题
	 * @param @param user
	 * @return void
	 * @throws
	 */
	boolean checkUserNameValitedOrNot(User user);

	/**
	 * @throws SQLException
	 * 
	 * @Title: checkCodeExitOrNot
	 * @Description:查找验证码是否存在的方法，如果存在那么返回用户
	 * @param @param user
	 * @return User
	 * @throws
	 */
	User checkCodeExitOrNot(String str) throws SQLException;

	/**
	 * @throws SQLException
	 * 
	 * @Title: changeuState
	 * @Description:改变代码的值
	 * @param @param user
	 * @return User
	 * @throws
	 */
	void changeuState(int getuId);

	/**
	 * @throws SQLException
	 * 
	 * @Title: clearCode
	 * @Description:清空
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
	 * @Description:通过用户名查找用户密码
	 * @param @param user
	 * @return User
	 * @throws
	 */
	User findUserPasswordByName(User user) throws SQLException;

	/**
	 * @throws SQLException
	 * 
	 * @Title: getUserByName
	 * @Description:通过用户名查找用户信息
	 * @param @param user
	 * @return void
	 * @throws
	 */
	User getUserByName(User user) throws SQLException;

}
