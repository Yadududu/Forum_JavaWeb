package com.lmj.dao;

import java.util.List;

import com.lmj.model.Answer;

public interface AnswerMapper {
	
	public List<Answer> FindAllAnswer(String dataId);
	
	public void InsertAnswer(Answer answer);
	
	/*DeleteAnswerByAnswer���**/
	public void DeleteAnswerById(String answerId);
	
	/*DeleteAnswerByAnswer���**/
	public void DeleteAnswerByDid(String dataId);
	
	public void DeleteAnswerByAnswer(Answer answer);
}
