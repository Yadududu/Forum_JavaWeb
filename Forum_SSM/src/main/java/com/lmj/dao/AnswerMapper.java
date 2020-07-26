package com.lmj.dao;

import java.util.List;

import com.lmj.model.Answer;

public interface AnswerMapper {
	
	public List<Answer> FindAllAnswer(String dataId);
	
	public void InsertAnswer(Answer answer);
	
	public void DeleteAnswerById(String answerId);
	
	public void DeleteAnswerByDid(String dataId);
}
