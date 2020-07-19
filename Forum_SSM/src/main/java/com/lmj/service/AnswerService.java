package com.lmj.service;

import java.util.List;

import com.lmj.model.Answer;

public interface  AnswerService {

	public List<Answer> FindAllAnswer(int dataID);

	public boolean InsertAnswer(Answer answer);
	
	public void DeleAnswerById(int id);
	
}
