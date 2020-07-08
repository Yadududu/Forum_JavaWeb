package com.lmj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.lmj.model.Answer;
import com.lmj.model.Data;
import com.lmj.util.HibernateUtils;

public class AnswerDao {

	public List<Answer> FindAllAnswer(String dataID) {
		Session session = HibernateUtils.getCurrentSession();
		String sql = "select user.username,answer.acontent,answer.d_id,answer.u_id,answer.id,answer.atime from answer join user on user.id=answer.u_id where d_id=?;";
		NativeQuery query = session.createSQLQuery(sql);
		query.setParameter(1, dataID);
		query.addEntity(Answer.class);
		
		List<Answer> answetList = query.list();
		
		return answetList;
		
	}
	public Answer FindAnswerbyId(String id) {
		Session session = HibernateUtils.getCurrentSession();
		String sql = "SELECT * FROM answer where id=?;";
		NativeQuery query = session.createSQLQuery(sql);
		query.setParameter(1, id);
		query.addEntity(Answer.class);
		
		Answer answer = (Answer) query.uniqueResult();
		
		return answer;
	}

	public void InsertAnswer(Answer answer) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(answer);
	}
	public void DeleAnswer(Answer answer) {
		Session session = HibernateUtils.getCurrentSession();
		session.delete(answer);
	}
}
