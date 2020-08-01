package com.lmj.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lmj.model.Answer;
import com.lmj.model.Data;
import com.lmj.util.MySqlUtil;

public class AnswerDao {

	public List<Answer> FindAllAnswer(int dataID) {
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "select answer.id,acontent,d_id,u_id,user.username from answer join user on user.id=answer.u_id where d_id=?;";
		List<Answer> answers = new ArrayList<Answer>();
		try {
			answers = runner.query(sql, new BeanListHandler<Answer>(Answer.class),dataID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answers;
	}

	public int InsertAnswer(Answer answer) {
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "insert into answer(acontent,u_id,d_id) value(?,?,?);";
		int temp = 0;
		try {
			temp = runner.update(sql, answer.getAcontent(),answer.getU_id(),answer.getD_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	public int DeleAnswerById(int id) {
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "delete from answer where id=?;";
		int temp = 0;
		try {
			temp = runner.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	public int DeleAnswerByDId(int did) {
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "delete from answer where d_id=?;";
		int temp = 0;
		try {
			temp = runner.update(sql, did);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
}
