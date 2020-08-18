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

	public User FindUserbyUsernameAndPassword(String username,String password) {
//		con = MySqlUtil.GetConnection();
//		String sql = "Select * From user where username=? and password = ?";
//
//		try {
//			ps = con.prepareStatement(sql);
//			ps.setString(1, user.username);
//			ps.setString(2, user.password);
//
//			rs = ps.executeQuery();
//			if (rs.next()) {
//				return true;
//			} else {
//				return false;
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			MySqlUtil.close(con, ps, rs);//使用QueryRunner,不用关闭
//		}
//		return false;
		
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "Select * From user where username=? and password = ?";
		User temp = null;
		try {
			temp = runner.query(sql, new BeanHandler<User>(User.class),username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	public User FindUserbyUsername(String username) {
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
	public User FindUserbyId(String userID) {
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "Select * From user where id=?";
		User temp = null;
		try {
			temp = runner.query(sql, new BeanHandler<User>(User.class),userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	public int InsertUser(User user) {
//		con = MySqlUtil.GetConnection();
//		String sql = "insert into user(username,password,phonenum) value(?,?,?)";
//
//		try {
//			ps = con.prepareStatement(sql);
//			ps.setString(1, user.username);
//			ps.setString(2, user.password);
//			ps.setString(3, user.phonenum);
//
//			int temp = ps.executeUpdate();
//			if (temp!=0) {
//				return true;
//			} else {
//				return false;
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			MySqlUtil.close(con, ps, rs);
//		}
//		return false;
		
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "insert into user(id,username,password,phonenum) value(?,?,?,?)";
		int temp = 0;
		try {
			temp = runner.update(sql, user.getId(),user.getUsername(),user.getPassword(),user.getPhonenum());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	public int UpdateUserPassword(User user) {
//		con = MySqlUtil.GetConnection();
//		String sql = "Update User set password = ? where username = ? and phonenum = ?";
//
//		try {
//			ps = con.prepareStatement(sql);
//			ps.setString(1, user.password);
//			ps.setString(2, user.username);
//			ps.setString(3, user.phonenum);
//
//			int temp = ps.executeUpdate();
//			if (temp!=0) {
//				return true;
//			} else {
//				return false;
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			MySqlUtil.close(con, ps, rs);
//		}
//		return false;
		
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "Update user set password = ? where username = ? and phonenum = ?";
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
