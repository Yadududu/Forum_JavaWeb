package com.lmj.service;

import java.util.List;

import com.lmj.dao.AnswerDao;
import com.lmj.model.Answer;

public class AnswerService {

	public List<Answer> FindAllAnswer(int dataID) {
		AnswerDao answerDao = new AnswerDao();
		return answerDao.FindAllAnswer(dataID);
	}

	public boolean AddAnswer(Answer answer) {
		AnswerDao answerDao = new AnswerDao();
		int temp = answerDao.AddAnswer(answer);
		return temp==0?false:true;
	}

}
