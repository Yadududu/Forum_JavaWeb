package com.lmj.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lmj.model.Answer;
import com.lmj.model.Data;
import com.lmj.service.AnswerService;
import com.lmj.service.DataService;
import com.lmj.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DetailAction extends ActionSupport {
	
	@Autowired
	private DataService dataService;
	@Autowired
	private AnswerService answerService;
	private String id;
	
	public String execute() throws Exception {
		//������������
		Data data = dataService.FindDatabyId(id);
		ActionContext.getContext().put("data", data);
		
		//���ػش�����
		List<Answer> answers=answerService.FindAllAnswer(id);
//		UserService userService = new UserService();
//		answers.forEach(answer->answer.setUsername(userService.FindUsernamebyId(answer.getU_id())));
//		answers.forEach(answer->System.out.println(answer.getUsername()));
		ActionContext.getContext().put("answers",answers);
		
		return "success";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
