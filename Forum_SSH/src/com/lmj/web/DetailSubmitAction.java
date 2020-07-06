package com.lmj.web;

import org.apache.struts2.dispatcher.HttpParameters;

import com.lmj.model.Answer;
import com.lmj.model.User;
import com.lmj.service.AnswerService;
import com.lmj.service.DataService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DetailSubmitAction extends ActionSupport implements ModelDriven<Answer>{
	
	private Answer answer = new Answer();
	
	@Override
	public String execute() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		answer.setU_id(user.getId());
		HttpParameters paras = ActionContext.getContext().getParameters();
		answer.setD_id(Integer.parseInt(paras.get("id").toString()));
		
		AnswerService answerService = new AnswerService();
		answerService.AddAnswer(answer);
		
		//»Ø´ðÊý+1
		DataService dataService = new DataService();
		dataService.UpdateAnsnum(answer.getD_id());
		
		ActionContext.getContext().put("id", answer.getD_id());
		
		return "success";
	}

	@Override
	public Answer getModel() {
		return answer;
	}

}
