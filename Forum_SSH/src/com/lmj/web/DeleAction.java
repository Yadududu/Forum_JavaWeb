package com.lmj.web;

import com.lmj.model.Answer;
import com.lmj.model.Data;
import com.lmj.service.AnswerService;
import com.lmj.service.DataService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleAction extends ActionSupport{
	
	private String delId;
	private String id;
	
	public String deleData() throws Exception {
		DataService dateService = new DataService();
		dateService.DeleDataById(delId);
		System.out.println("删除成功");
		return "deleData";
	}
	public String deleAnswer() throws Exception {
		AnswerService answerService = new AnswerService();
		answerService.DeleAnswerById(delId);
		ActionContext.getContext().put("id", id);
		
		//回答数-1
		DataService dataService = new DataService();
		dataService.UpdateAnsnum(id,-1);
		
		return "deleAnswer";
	}
	public String getDelId() {
		return delId;
	}
	public void setDelId(String delId) {
		this.delId = delId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
