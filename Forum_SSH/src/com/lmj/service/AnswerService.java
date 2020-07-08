package com.lmj.service;

import java.util.List;

import org.hibernate.Transaction;

import com.lmj.dao.AnswerDao;
import com.lmj.dao.DataDao;
import com.lmj.model.Answer;
import com.lmj.model.Data;
import com.lmj.util.HibernateUtils;

public class AnswerService {

	public List<Answer> FindAllAnswer(String dataID) {
		AnswerDao answerDao = new AnswerDao();
		Transaction transaction = HibernateUtils.getCurrentSession().beginTransaction();
		List<Answer> answerList=null;
		try {
			answerList = answerDao.FindAllAnswer(dataID);
		}catch(Exception e){
			transaction.rollback();
		}
		transaction.commit();
		
		return answerList;
	}

	public void InsertAnswer(Answer answer) {
		AnswerDao answerDao = new AnswerDao();
		Transaction transaction = HibernateUtils.getCurrentSession().beginTransaction();
		try {
			answerDao.InsertAnswer(answer);
		}catch(Exception e){
			transaction.rollback();
		}
		transaction.commit();
	}
	public void DeleAnswerById(String id) {
		AnswerDao answerDao = new AnswerDao();
		Transaction transaction = HibernateUtils.getCurrentSession().beginTransaction();
		try {
			Answer answer = answerDao.FindAnswerbyId(id);
			answerDao.DeleAnswer(answer);
		}catch(Exception e) {
			transaction.rollback();
		}
		transaction.commit();
	}

}
