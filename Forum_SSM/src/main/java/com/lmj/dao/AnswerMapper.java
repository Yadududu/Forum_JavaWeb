package com.lmj.dao;

import java.util.List;

import com.lmj.model.Answer;

public interface AnswerMapper {
	
	public List<Answer> FindAllAnswer(String dataId);
	
	public void InsertAnswer(Answer answer);
	
	/*DeleteAnswerByAnswerÌæ´ú**/
	public void DeleteAnswerById(String answerId);
	
	/*DeleteAnswerByAnswerÌæ´ú**/
	public void DeleteAnswerByDid(String dataId);
	
	public void DeleteAnswerByAnswer(Answer answer);
}
