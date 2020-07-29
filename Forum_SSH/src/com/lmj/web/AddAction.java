package com.lmj.web;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		Date date=new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = format.format(date);
		data.setDtime(time);
		
		DataService dataService = new DataService();
		dataService.InsertData(data);
		String id = dataService.FindDataIdbyData(data);
		if(id=="") {
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
