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
			if (users != null && users.size() > 0) {// �����ʾ���Ϸ���,�����Ѿ�������
				return true;
			} else {
				return false;// �����ʾ�Ϸ���
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public User findUserByCode(String code) throws SQLException {
		System.out.println("���Ǽ�����û��ķ�������ִ����");
		// ��ȡQueryRunner
		QueryRunner runner = JDBCUtils.getQueryRunner();
		// дSQL���
		String sql = "select * from t_user where t_user.uCode=?";
		// ִ��SQL���
		List<User> users = runner.query(sql, new BeanListHandler<User>(
				User.class), code);
		// �ж�
		if (users.size() > 0) {
			return users.get(0);
		}
		throw new RuntimeException("����Ϊnull");
	}

	@Override
	public void changeUState(int getuId) {
		QueryRunner runner = JDBCUtils.getQueryRunner();
		String sql = "update t_user set uState=1 where uId=?";
		try {
			runner.update(sql, getuId);
			System.out.println("��ִ����");
		} catch (SQLException e) {
			throw new RuntimeException("�����û�״̬ʧ��");
		}
	}

	@Override
	public void clearCode(int getuId) {
		QueryRunner runner = JDBCUtils.getQueryRunner();
		String sql = "update t_user set uCode='' where uId=?";
		try {
			runner.update(sql, getuId);
		} catch (SQLException e) {
			throw new RuntimeException("��ռ�����״̬ʧ��");
		}
	}

	@Override
	public User findPasswordByName(User user) throws SQLException{
		QueryRunner runner = JDBCUtils.getQueryRunner();
		System.out.println("����ͨ���û������������userdao��ִ����");
		String sql = "select uPassword from t_user where t_user.uName=?";
		return runner.query(sql, new BeanHandler<User>(User.class),
				user.getuName());
	}

	@Override
	public User getUserByName(User user) throws SQLException {
		QueryRunner runner = JDBCUtils.getQueryRunner();
		System.out.println("����ͨ���û������������userdao��ִ����");
		String sql = "select * from t_user where t_user.uName=?";
		return runner.query(sql, new BeanHandler<User>(User.class),
				user.getuName());
	
	}
}
