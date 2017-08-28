package com.qf.shopping.user.service.impl;

import java.sql.SQLException;

import com.qf.shopping.user.dao.IUserDao;
import com.qf.shopping.user.dao.impl.UserDao;
import com.qf.shopping.user.entity.User;
import com.qf.shopping.user.service.IUserService;

public class UserService implements IUserService {
	IUserDao userDao = new UserDao();

	@Override
	public void regist(User user) {
		userDao.save(user);
	}

	@Override
	public boolean checkUserNameValitedOrNot(User user) {
		if (null == user.getuName() || "".equals(user.getuName())) {
			throw new RuntimeException("用户名为空...");
		} else {
			return userDao.findUserNameExitOrNot(user);
		}
	}

	@Override
	public User checkCodeExitOrNot(String code) {
		if (null == code || "".equals(code)) {
			throw new RuntimeException("激活码为空！");
		}
		try {
			return userDao.findUserByCode(code);
		} catch (SQLException e) {
			throw new RuntimeException("激活码出问题了");
		}
	}

	@Override
	public void changeuState(int getuId) {
		if (getuId < 0) {
			throw new RuntimeException("用户ID为空，无法改变用户状态");
		}
		userDao.changeUState(getuId);
	}

	@Override
	public void clearCode(int getuId) {
		if (getuId < 0) {
			throw new RuntimeException("用户ID为空，无法改变用户状态");
		}
		userDao.clearCode(getuId);
	}

	@Override
	public User findUserPasswordByName(User user) throws SQLException {
		if (null == user.getuName() || "".equals(user.getuName())) {
			throw new RuntimeException("用户名为空...");
		}
		return userDao.findPasswordByName(user);
	}

	@Override
	public User getUserByName(User user) throws SQLException {
		if (null == user.getuName() || "".equals(user.getuName())) {
			throw new RuntimeException("用户名为空...");
		}
		return userDao.getUserByName(user);
}
}