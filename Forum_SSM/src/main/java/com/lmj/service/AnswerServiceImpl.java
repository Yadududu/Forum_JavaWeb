package com.lmj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmj.dao.AnswerMapper;
import com.lmj.model.Answer;

@Service
public class AnswerServiceImpl implements AnswerService{
	
	@Autowired
	private AnswerMapper answerDao;
	
	public List<Answer> FindAllAnswer(String dataID) {
		return answerDao.FindAllAnswer(dataID);
	}

	public void InsertAnswer(Answer answer) {
		answerDao.InsertAnswer(answer);
	}
	public void DeleteAnswerById(String answerId) {
		answerDao.DeleteAnswerById(answerId);
	}
}
