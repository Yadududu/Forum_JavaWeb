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
		String sql = "SELECT * FROM data join answer on data.id = answer.d_id where data.id=?;";
		List<Answer> answers = new ArrayList<Answer>();
		try {
			answers = runner.query(sql, new BeanListHandler<Answer>(Answer.class),dataID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answers;
	}

	public boolean AddAnswer(Answer answer) {
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "insert into answer(content,username,d_id) value(?,?,?);";
		int temp = 0;
		try {
			temp = runner.update(sql, answer.getContent(),answer.getUsername(),answer.getD_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp==0?false:true;
	}
}
