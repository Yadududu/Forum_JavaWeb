package com.lmj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lmj.model.Answer;

@Repository
public class AnswerDao {
	
	@Autowired
    private SessionFactory sessionFactory;

	public List<Answer> FindAllAnswer(String dataID) {
		Session session = sessionFactory.getCurrentSession();
//		String sql = "select user.username,answer.acontent,answer.d_id,answer.u_id,answer.id,answer.atime from answer join user on user.id=answer.u_id where d_id=?;";
//		NativeQuery query = session.createSQLQuery(sql);
//		query.setParameter(1, dataID);
//		query.addEntity(Answer.class);
//		List<Answer> answetList = query.list();
		
		String sql = "select * from answer where d_id=? order by answer.atime";
		NativeQuery query = session.createSQLQuery(sql);
		query.setParameter(1, dataID);
		query.addEntity(Answer.class);
		List<Answer> answetList = query.list();
		
		return answetList;
		
	}
	public Answer FindAnswerbyId(String id) {
		Session session = sessionFactory.getCurrentSession();
//		String sql = "SELECT * FROM answer where id=?;";
//		NativeQuery query = session.createSQLQuery(sql);
//		query.setParameter(1, id);
//		query.addEntity(Answer.class);
//		Answer answer = (Answer) query.uniqueResult();
		
		Answer answer = session.get(Answer.class, id);
		
		return answer;
	}

	public void InsertAnswer(Answer answer) {
		Session session = sessionFactory.getCurrentSession();
		session.save(answer);
	}
	public void DeleAnswer(Answer answer) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(answer);
	}
}
