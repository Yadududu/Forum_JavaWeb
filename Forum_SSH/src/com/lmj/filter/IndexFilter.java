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

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		DataService dataService = new DataService();
    	List<Data> datas = dataService.FindAllData();
    	
//    	UserService userService = new UserService();
//    	datas.forEach(data->data.setUsername(userService.FindUsernamebyId(data.getU_id())));
    	
//    	datas.forEach(data->System.out.println(data));
    	request.getServletContext().setAttribute("initDatas", datas);
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
