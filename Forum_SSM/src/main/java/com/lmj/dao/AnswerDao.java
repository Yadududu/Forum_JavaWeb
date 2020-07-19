package com.lmj.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lmj.model.Answer;
import com.lmj.model.Data;

public class AnswerDao {

	public List<Answer> FindAllAnswer(int dataID) {
//		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
//		String sql = "select * from answer join user on user.id=answer.u_id where d_id=?;";
		List<Answer> answers = new ArrayList<Answer>();
//		try {
//			answers = runner.query(sql, new BeanListHandler<Answer>(Answer.class),dataID);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return answers;
	}

	public int InsertAnswer(Answer answer) {
//		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
//		String sql = "insert into answer(content,u_id,d_id) value(?,?,?);";
		int temp = 0;
//		try {
//			temp = runner.update(sql, answer.getContent(),answer.getU_id(),answer.getD_id());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return temp;
	}

	public int DeleAnswerById(int id) {
//		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
//		String sql = "delete from answer swhere id=?;";
		int temp = 0;
//		try {
//			temp = runner.update(sql, id);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return temp;
	}
}
