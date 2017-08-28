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
	 * @Description: 检测用户名是否合法
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
	 * @Description: 通过激活码找到用户
	 * @param @param user
	 * @return User
	 * @throws
	 */
	User findUserByCode(String code) throws SQLException;
	/**
	 * 
	 * @Title: changeUState
	 * @Description: 改变用户状态
	 * @param @param user
	 * @return void
	 * @throws
	 */
	void changeUState(int getuId);
	/**
	 * 
	 * @Title: clearCode
	 * @Description: 清空验证码
	 * @param @param user
	 * @return void
	 * @throws
	 */
	void clearCode(int getuId);
	/**
	 * @throws SQLException 
	 * 
	 * @Title: findPasswordByName
	 * @Description: 通过用户名查找密码
	 * @param @param user
	 * @return void
	 * @throws
	 */
	User findPasswordByName(User user) throws SQLException;
	/**
	 * @throws SQLException 
	 * @Title: getUserByName
	 * @Description: 通过用户名查找用户信息
	 * @param @param user
	 * @return void
	 * @throws
	 */
	User getUserByName(User user) throws SQLException;

}
