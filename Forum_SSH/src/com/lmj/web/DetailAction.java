package com.lmj.web;

import java.util.List;

import com.lmj.model.Answer;
import com.lmj.model.Data;
import com.lmj.service.AnswerService;
import com.lmj.service.DataService;
import com.lmj.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DetailAction extends ActionSupport {
	private int id;
	
	public String execute() throws Exception {
		//返回帖子内容
		Data data = new Data();
		DataService dataService = new DataService();
		data = dataService.GetData(id);
		ActionContext.getContext().put("data", data);
		
		//返回回答内容
		AnswerService answerService = new AnswerService();
		UserService userService = new UserService();
		List<Answer> answers=answerService.FindAllAnswer(id);
		answers.forEach(answer->answer.setUsername(userService.FindUsername(answer.getU_id())));
		ActionContext.getContext().put("answers",answers);
		
		return "success";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
