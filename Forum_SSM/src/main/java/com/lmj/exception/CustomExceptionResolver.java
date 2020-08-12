package com.lmj.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * �Զ����쳣������
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,Exception ex) {
		ex.printStackTrace();
		CustomException customException = null;
		//����׳�����ϵͳ�Զ����쳣��ֱ��ת��
		if (ex instanceof CustomException) {
			customException = (CustomException) ex;
		} else {
			//����׳��Ĳ���ϵͳ�Զ����쳣�����¹���һ��ϵͳ�����쳣��
			customException = new CustomException("ϵͳ��������ϵͳ���� Ա��ϵ��");
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", customException.getMessage());
		modelAndView.setViewName("404");
		return modelAndView;
	}
}