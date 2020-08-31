package com.lmj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmj.dao.AnswerDao;
import com.lmj.model.Answer;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerDao answerDao;

	public List<Answer> FindAllAnswer(String dataID) {
		List<Answer> answerList = answerDao.FindAllAnswer(dataID);
		return answerList;
	}

	public void InsertAnswer(Answer answer) {
		answerDao.InsertAnswer(answer);
	}
	public void DeleteAnswerById(String id) {
		Answer answer = answerDao.FindAnswerbyId(id);
		answerDao.DeleAnswer(answer);
	}

}
