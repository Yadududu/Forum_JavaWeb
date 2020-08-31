package com.lmj.web;

import org.springframework.beans.factory.annotation.Autowired;

import com.lmj.model.Answer;
import com.lmj.model.Data;
import com.lmj.service.AnswerService;
import com.lmj.service.DataService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleAction extends ActionSupport{
	
	@Autowired
	private DataService dataService;
	@Autowired
	private AnswerService answerService;
	private String delId;
	private String dId;
	
	public String deleData() throws Exception {
		dataService.DeleteDataById(delId);
		System.out.println("删除成功");
		return "deleData";
	}
	public String deleAnswer() throws Exception {
		answerService.DeleteAnswerById(delId);
		ActionContext.getContext().put("id", dId);
		
		//回答数-1
		dataService.UpdateDataAnsnum(dId,-1);
		
		return "deleAnswer";
	}
	public String getDelId() {
		return delId;
	}
	public void setDelId(String delId) {
		this.delId = delId;
	}
	public String getdId() {
		return dId;
	}
	public void setdId(String dId) {
		this.dId = dId;
	}
	
}
