package com.lmj.web.intercept;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserIntercept extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//�ж��Ƿ��е�½,û�е�½��ת����½����
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		Object object = session.get("user");
		if(object!=null) {
			//����
			return invocation.invoke();
		}else {
			//��ת����½����
			return "toLogin";
		}
	}

}
