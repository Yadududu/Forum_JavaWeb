package com.lmj.web;

import com.lmj.model.User;
import com.lmj.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
	
	private User user=new User();
	
	public String login() throws Exception {
		UserService userService=new UserService();
		int id = userService.FindUserId(user);
		if(id==0) {
			System.out.println("��½ʧ��");
			ActionContext.getContext().put("loginError", "�û��������������!");
			return "fail";
		}else {
			System.out.println("��½�ɹ�");
			user.setId(id);
			ActionContext.getContext().getSession().put("user", user);
			return "success";
		}
	}

	@Override
	public User getModel() {
		return user;
	}
}
