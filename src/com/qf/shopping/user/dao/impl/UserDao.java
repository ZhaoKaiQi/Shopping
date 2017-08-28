package com.qf.shopping.user.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.shopping.user.dao.IUserDao;
import com.qf.shopping.user.entity.User;
import com.qf.shopping.utils.JDBCUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class UserDao implements IUserDao {

	@Override
	public void save(User user) {
		QueryRunner runner = JDBCUtils.getQueryRunner();
		String sql = "insert into t_user(uName,uPassword,uCode,uState) values(?,?,?,?)";
		try {
			runner.update(sql, user.getuName(), user.getuPassword(),
					user.getuCode(), user.getuState());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public boolean findUserNameExitOrNot(User user) {
		QueryRunner runner = JDBCUtils.getQueryRunner();
		String sql = "select * from t_user where t_user.uName=?";
		try {
			List<User> users = runner.query(sql, new BeanListHandler<User>(
					User.class), user.getuName());
			if (users != null && users.size() > 0) {// 这个表示不合法的,数据已经存在了
				return true;
			} else {
				return false;// 这个表示合法的
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public User findUserByCode(String code) throws SQLException {
		System.out.println("我是激活查用户的方法，我执行了");
		// 获取QueryRunner
		QueryRunner runner = JDBCUtils.getQueryRunner();
		// 写SQL语句
		String sql = "select * from t_user where t_user.uCode=?";
		// 执行SQL语句
		List<User> users = runner.query(sql, new BeanListHandler<User>(
				User.class), code);
		// 判定
		if (users.size() > 0) {
			return users.get(0);
		}
		throw new RuntimeException("数据为null");
	}

	@Override
	public void changeUState(int getuId) {
		QueryRunner runner = JDBCUtils.getQueryRunner();
		String sql = "update t_user set uState=1 where uId=?";
		try {
			runner.update(sql, getuId);
			System.out.println("我执行了");
		} catch (SQLException e) {
			throw new RuntimeException("更新用户状态失败");
		}
	}

	@Override
	public void clearCode(int getuId) {
		QueryRunner runner = JDBCUtils.getQueryRunner();
		String sql = "update t_user set uCode='' where uId=?";
		try {
			runner.update(sql, getuId);
		} catch (SQLException e) {
			throw new RuntimeException("清空激活码状态失败");
		}
	}

	@Override
	public User findPasswordByName(User user) throws SQLException{
		QueryRunner runner = JDBCUtils.getQueryRunner();
		System.out.println("调用通过用户名查找密码的userdao层执行了");
		String sql = "select uPassword from t_user where t_user.uName=?";
		return runner.query(sql, new BeanHandler<User>(User.class),
				user.getuName());
	}

	@Override
	public User getUserByName(User user) throws SQLException {
		QueryRunner runner = JDBCUtils.getQueryRunner();
		System.out.println("调用通过用户名查找密码的userdao层执行了");
		String sql = "select * from t_user where t_user.uName=?";
		return runner.query(sql, new BeanHandler<User>(User.class),
				user.getuName());
	
	}
}
