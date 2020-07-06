package com.lmj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.lmj.model.User;
import com.lmj.util.MySqlUtil;

public class UserDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public User FindUserId(User user) {
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "Select * From user where username=? and password = ?";
		User temp = null;
		try {
			temp = runner.query(sql, new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	public User FindUser(String username) {
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "Select * From user where username=?";
		User temp = null;
		try {
			temp = runner.query(sql, new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	public User FindUsername(Integer id) {
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "Select * From user where id=?";
		User temp = null;
		try {
			temp = runner.query(sql, new BeanHandler<User>(User.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	public int InsertUser(User user) {
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "insert into user(username,password,phonenum) value(?,?,?)";
		int temp = 0;
		try {
			temp = runner.update(sql, user.getUsername(),user.getPassword(),user.getPhonenum());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	public int UpdateUser(User user) {
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "Update User set password = ? where username = ? and phonenum = ?";
		int temp = 0;
		try {
			temp = runner.update(sql, user.getPassword(),user.getUsername(),user.getPhonenum());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
}
