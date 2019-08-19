package com.bookshop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description
 * @author 李洋
 * @address 北大青鸟沈阳三好中心
 * @created 2017年9月5日 上午8:56:48
 * @version 1.0.0
 */
public class EncodingFilter implements Filter{

	//编码
	private String encoding;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//向下转型为其子类
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		//转码
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		//放行
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filter) throws ServletException {
		//拿到web.xml中的字符集编码
		this.encoding = filter.getInitParameter("encode");
	}
}
