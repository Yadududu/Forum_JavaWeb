package com.lmj.filter;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.lmj.dao.DataMapper;
import com.lmj.model.Data;
import com.lmj.service.DataService;
import com.lmj.service.DataServiceImpl;

//@WebFilter("/IndexFilter")
@Component
public class IndexFilter implements Filter {

	@Autowired
	private DataService dataService;

	public IndexFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Ö´ÐÐ¹ýÂËÆ÷");
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		SqlSessionFactory factory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
//		SqlSession session = factory.openSession();
		
//		DataMapper dataMapper = session.getMapper(DataMapper.class);
//		DataService dataService = (DataService) ac.getBean(DataService.class);
		List<Data> datas = dataService.FindAllData();
//		datas.forEach(data->System.out.println(data));

		request.getServletContext().setAttribute("initDatas", datas);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
