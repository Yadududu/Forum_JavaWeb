package com.lmj.web;

import java.util.regex.Pattern;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.lmj.model.User;
import com.lmj.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class VerifyAction extends ActionSupport implements ModelDriven<User>{

	@Autowired
	private UserService userService;
	private User user = new User();

	public String execute() throws Exception {
		String username = ServletActionContext.getRequest().getParameter("username");
		if(username!=null) {
			boolean isEmpty = username=="";
			if(isEmpty) {
				ServletActionContext.getResponse().getWriter().append("{\"isSuccess\":"+!isEmpty+"}");
				return NONE;
			}
			boolean isExist = userService.FindUserByUsername(username);
			ServletActionContext.getResponse().getWriter().append("{\"isSuccess\":"+!isExist+"}");
		}
		
		String password = ServletActionContext.getRequest().getParameter("password");
		String checkPassword = ServletActionContext.getRequest().getParameter("checkPassword");
		if(password!=null & checkPassword==null) {
			boolean isEmpty = password=="";
			ServletActionContext.getResponse().getWriter().append("{\"isSuccess\":"+!isEmpty+"}");
		}
		if(checkPassword!=null) {
			boolean isEqual = checkPassword.equals(password);
			ServletActionContext.getResponse().getWriter().append("{\"isSuccess\":"+isEqual+"}");
		}
		
		String phonenum = ServletActionContext.getRequest().getParameter("phonenum");
		if(phonenum!=null) {
			boolean isEmpty = phonenum=="";
			if(isEmpty) {
				ServletActionContext.getResponse().getWriter().append("{\"isSuccess\":"+!isEmpty+"}");
			}
			String pattern = "^[1]([3-9])[0-9]{9}$";
			String content = phonenum;
			boolean isMatch = Pattern.matches(pattern, content);
			ServletActionContext.getResponse().getWriter().append("{\"isSuccess\":"+ isMatch +"}");
		}
		return NONE;
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
}
