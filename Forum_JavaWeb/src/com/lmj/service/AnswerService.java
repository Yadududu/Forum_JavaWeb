package com.lmj.service;

import java.util.List;

import com.lmj.dao.AnswerDao;
import com.lmj.model.Answer;

public class AnswerService {

	public List<Answer> FindAllAnswer(String dataID) {
		AnswerDao answerDao = new AnswerDao();
		return answerDao.FindAllAnswer(dataID);
	}

	public boolean InsertAnswer(Answer answer) {
		AnswerDao answerDao = new AnswerDao();
		int temp = answerDao.InsertAnswer(answer);
		return temp==0?false:true;
	}
	public void DeleAnswerById(String answerID) {
		AnswerDao answerDao = new AnswerDao();
		answerDao.DeleAnswerById(answerID);
	}
	
}
