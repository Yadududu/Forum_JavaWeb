package com.lmj.service;

import java.util.List;

import javax.annotation.Resource;

import com.lmj.dao.AnswerDao;
import com.lmj.dao.UserMapper;
import com.lmj.model.Answer;


public class AnswerServiceImpl implements AnswerService{
	
	
	public List<Answer> FindAllAnswer(int dataID) {
		AnswerDao answerDao = new AnswerDao();
		return answerDao.FindAllAnswer(dataID);
	}

	public boolean InsertAnswer(Answer answer) {
		AnswerDao answerDao = new AnswerDao();
		int temp = answerDao.InsertAnswer(answer);
		return temp==0?false:true;
	}
	public void DeleAnswerById(int id) {
		AnswerDao answerDao = new AnswerDao();
		answerDao.DeleAnswerById(id);
	}
}
