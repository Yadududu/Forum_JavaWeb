package com.lmj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.lmj.model.User;

//@Repository("userMapper")
public class UserDao {

	public User FindUserbyUsernameAndPassword(String username,String password) {
//		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
//		String sql = "Select * From user where username=? and password = ?";
		User temp = null;
//		try {
//			temp = runner.query(sql, new BeanHandler<User>(User.class),username,password);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return temp;
	}
	public User FindUserbyUsername(String username) {
//		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
//		String sql = "Select * From user where username=?";
		User temp = null;
//		try {
//			temp = runner.query(sql, new BeanHandler<User>(User.class),username);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return temp;
	}
	public User FindUserbyId(Integer id) {
//		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
//		String sql = "Select * From user where id=?";
		User temp = null;
//		try {
//			temp = runner.query(sql, new BeanHandler<User>(User.class),id);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return temp;
	}
	
	public int InsertUser(User user) {
//		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
//		String sql = "insert into user(username,password,phonenum) value(?,?,?)";
		int temp = 0;
//		try {
//			temp = runner.update(sql, user.getUsername(),user.getPassword(),user.getPhonenum());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return temp;
	}
	
	public int UpdateUserPassword(User user) {
//		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
//		String sql = "Update User set password = ? where username = ? and phonenum = ?";
		int temp = 0;
//		try {
//			temp = runner.update(sql, user.getPassword(),user.getUsername(),user.getPhonenum());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return temp;
	}
}
