package com.jsj.hn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jsj.hn.model.User;
//@WebFilter(urlPatterns=("/*")) =
@WebFilter("/*")
public class AuthoritieFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session=((HttpServletRequest)request).getSession();
		User loginUser=(User)session.getAttribute("loginUser");
		String requestPath=((HttpServletRequest)request).getServletPath();
		if(loginUser!=null&&loginUser.getRoleId()==1 || requestPath.endsWith("index") || requestPath.contains("ValidateCodeServlet")) {
			chain.doFilter(request, response);
		}else if(loginUser==null&&requestPath.contains("admin") || requestPath.contains("admin")&&loginUser.getRoleId()!=1 ) {
			request.setAttribute("tip", "非法操作！请登录管理员账户！");
			RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
		}else{
			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
