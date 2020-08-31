package com.lmj.web;

import com.lmj.model.User;
import com.lmj.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FindPasswordAction extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	
	public String findPassword() throws Exception {
		
		if(user.getUsername()==""||user.getPassword()==""||user.getPhonenum()==""||user.getCheckPassword()=="") {
			System.out.println("修改失败");
			ActionContext.getContext().put("error", "请填写好信息,不能留空!");
			return "fail";
		}
		if(!user.getPassword().equals(user.getCheckPassword())) {
			System.out.println("修改失败");
			ActionContext.getContext().put("error", "两次填写的密码不一致!");
			return "fail";
		}
		
		UserService userService = new UserService();
		boolean temp = userService.UpdateUserPassword(user);
		if(temp) {
			System.out.println("修改成功");
			return "success";
		}else {
			System.out.println("修改失败");
			ActionContext.getContext().put("error", "填写信息有误,修改失败!");
			return "fail";
		}
	}
	
	@Override
	public User getModel() {
		return user;
	}
}
