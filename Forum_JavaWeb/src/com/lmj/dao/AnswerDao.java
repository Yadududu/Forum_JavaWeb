package com.lmj.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lmj.model.Answer;
import com.lmj.model.User;
import com.lmj.util.MySqlUtil;

public class AnswerDao {

	public List<Answer> FindAllAnswer(String dataID) {
//		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
//		String sql = "select answer.id,acontent,d_id,u_id,user.username from answer join user on user.id=answer.u_id where d_id=?";
//		List<Answer> answers = new ArrayList<Answer>();
//		try {
//			answers = runner.query(sql, new BeanListHandler<Answer>(Answer.class),dataID);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return answers;
		
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql1 = "select * from answer where d_id=? order by answer.atime";
		String sql2 = "select * from user where id=?";
		List<Answer> answers = new ArrayList<Answer>();
		try {
			answers = runner.query(sql1, new BeanListHandler<Answer>(Answer.class),dataID);
			answers.forEach(answer->{
				try {
					User user = runner.query(sql2, new BeanHandler<User>(User.class), answer.getU_id());
					answer.setUser(user);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answers;
	}

	public int InsertAnswer(Answer answer) {
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "insert into answer(id,atime,acontent,u_id,d_id) value(?,?,?,?,?);";
		int temp = 0;
		try {
			temp = runner.update(sql, answer.getId(),answer.getAtime(),answer.getAcontent(),answer.getU_id(),answer.getD_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	public int DeleAnswerById(String answerID) {
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "delete from answer where id=?;";
		int temp = 0;
		try {
			temp = runner.update(sql, answerID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	public int DeleAnswerByDId(String dataID) {
		QueryRunner runner = new QueryRunner(MySqlUtil.GetDataSource());
		String sql = "delete from answer where d_id=?;";
		int temp = 0;
		try {
			temp = runner.update(sql, dataID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
}
