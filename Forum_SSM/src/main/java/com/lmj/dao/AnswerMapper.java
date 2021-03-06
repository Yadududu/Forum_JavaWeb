package com.lmj.dao;

import java.util.List;

import com.lmj.model.Answer;

public interface AnswerMapper {
	
	public List<Answer> FindAllAnswer(String dataId);
	
	public void InsertAnswer(Answer answer);
	
	/*DeleteAnswerByAnswer╠Š┤˙**/
	public void DeleteAnswerById(String answerId);
	
	/*DeleteAnswerByAnswer╠Š┤˙**/
	public void DeleteAnswerByDid(String dataId);
	
	public void DeleteAnswerByAnswer(Answer answer);
}
