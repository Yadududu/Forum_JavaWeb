package com.lmj.web.intercept;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserIntercept extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//判断是否有登陆,没有登陆跳转到登陆界面
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		Object object = session.get("user");
		if(object!=null) {
			//放行
			return invocation.invoke();
		}else {
			//跳转到登陆界面
			return "toLogin";
		}
	}

}
