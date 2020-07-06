package com.lmj.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lmj.model.Data;
import com.lmj.util.MySqlUtil;

public class DataDao {
	
	public List<Data> GetAllData() {
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "SELECT user.username,data.id,data.title,data.content,data.ansnum,data.u_id FROM user join data on user.id = data.u_id;";
		List<Data> datas = new ArrayList<Data>();
		try {
			datas = runner.query(sql, new BeanListHandler<Data>(Data.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datas;
	}

	public Data GetData(int dataID) {
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "SELECT user.username,data.id,data.title,data.content,data.ansnum,data.u_id FROM user join data on user.id = data.u_id where data.id=?;";
		Data data = new Data();
		try {
			data = runner.query(sql, new BeanHandler<Data>(Data.class), dataID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}


	public int AddData(Data data) {
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "insert into data(title,content,ansnum,u_id) value(?,?,?,?);";
		int temp = 0;
		try {
			temp = runner.update(sql,  data.getTitle(), data.getContent(), data.getAnsnum(), data.getU_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	public int GetID(Data data) {
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "SELECT * FROM data where title=? and content=? and u_id=?;";
		Data d = new Data();
		try {
			d = runner.query(sql, new BeanHandler<Data>(Data.class), data.getTitle(),data.getContent(),data.getU_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d.getId();
	}

	public int UpdateAnsnum(Integer id, int ansnum) {
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "update data set ansnum=? where id=?;";
		int temp = 0;
		try {
			temp = runner.update(sql, ansnum, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
}
