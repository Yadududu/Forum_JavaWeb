package com.lmj.web;

import com.lmj.model.Data;
import com.lmj.model.User;
import com.lmj.service.DataService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddAction extends ActionSupport implements ModelDriven<Data>{
	
	private Data data = new Data();
	
	public String execute() throws Exception {
		
		data.setAnsnum(0);
		User user = (User)ActionContext.getContext().getSession().get("user");
		data.setU_id(user.getId());
		data.setUsername(user.getUsername());
		
		DataService dataService = new DataService();
		int id = dataService.AddData(data);
		if(id==0) {
			System.out.println("发布失败");
			return "fail";
		}else {
			ActionContext.getContext().put("id", id);
			System.out.println("发布成功");
			return "success";
		}
	}


	@Override
	public Data getModel() {
		return data;
	}
	
}
