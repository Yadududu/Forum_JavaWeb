package com.lmj.controller.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class UserIntercept implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		System.out.println("preHandle ������������");
		
		//�ж��Ƿ��е�½,û�е�½��ת����½����
		
		HttpSession session = request.getSession();
		Object object = session.getAttribute("user");
		if(object!=null) {
			//����
			return true;
		}else {
			//��ת����½����
//			request.getRequestDispatcher("/login.jsp").forward(request,response);
			response.sendRedirect(request.getContextPath()+ "/login.jsp");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		System.out.println("postHandle ����ִ����");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
//		System.out.println("afterCompletion ����ִ����");
	}
}
