package com.lmj.service;

import java.util.List;

import com.lmj.model.Answer;

public interface  AnswerService {

	public List<Answer> FindAllAnswer(String dataID);

	public void InsertAnswer(Answer answer);
	
	public void DeleteAnswerById(String answerid);
	
}
