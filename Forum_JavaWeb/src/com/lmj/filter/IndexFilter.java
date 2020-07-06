package com.lmj.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.lmj.model.Data;
import com.lmj.service.DataService;
import com.lmj.service.UserService;

//@WebFilter("/IndexFilter")
public class IndexFilter implements Filter {

    public IndexFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}
	//刷新首页
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("读取数据库,获取datas");
		DataService dataService = new DataService();
		List<Data> datas = dataService.GetDatas();
		
		UserService userService = new UserService();
    	datas.forEach(data->data.setUsername(userService.FindUsername(data.getU_id())));
		request.getServletContext().setAttribute("initDatas", datas);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
