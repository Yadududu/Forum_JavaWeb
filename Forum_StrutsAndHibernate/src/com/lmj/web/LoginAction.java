package com.lmj.web;

import com.lmj.model.User;
import com.lmj.service.UserService;
import com.lmj.util.SessionManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
	
	private User user=new User();
	
	public String login() throws Exception {
		UserService userService=new UserService();
		User u = userService.FindUserbyUsernameAndPassword(user.getUsername(),user.getPassword());
		if(u==null) {
			System.out.println("��½ʧ��");
			ActionContext.getContext().put("loginError", "�û��������������!");
			return "fail";
		}else {
			System.out.println("��½�ɹ�");
			ActionContext.getContext().getSession().put("user", u);
			return "success";
		}
	}
	
	public String logout() throws Exception {
		user = (User) ActionContext.getContext().getSession().get("user");
		ActionContext.getContext().getSession().remove("user");
		if(SessionManager.SessionMap.containsKey(user.getUsername())){
			SessionManager.SessionMap.remove(user.getUsername());
		}
		return "success";
	}

	@Override
	public User getModel() {
		return user;
	}
}
