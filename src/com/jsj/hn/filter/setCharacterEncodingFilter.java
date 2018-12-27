package com.jsj.hn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class setCharacterEncodingFilter implements Filter {
	String encoding;
	@Override
	public void destroy() {
		this.encoding=null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(encoding==null) {
			encoding="UTTF-8";
		}
		//设置请求编码
		request.setCharacterEncoding("UTF-8");
		//过滤传递
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.encoding=config.getInitParameter("ecoding");
	}

}
