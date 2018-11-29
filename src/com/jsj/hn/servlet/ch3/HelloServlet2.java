package com.jsj.hn.servlet.ch3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/HelloServlet2")
public class HelloServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HelloServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String username=config.getInitParameter("username");
		String password=config.getInitParameter("password");
		System.out.println("username==="+username+"\tpassword==="+password);
	}
	public void destroy() {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应到客户端的MIME类型和编码方式
		response.setContentType("text/html;charset=UTF-8");
		//使用ServletContext对象获取所有初始化参数
		Enumeration<String> paramNames=super.getServletContext().getInitParameterNames();
		//使用ServletContext 对象获取某个初始化参数
		String sitename=super.getServletContext().getInitParameter("sitename");
		String developer=super.getServletContext().getInitParameter("developer");
		
		PrintWriter out=response.getWriter();
		while(paramNames.hasMoreElements()) {
			String name=paramNames.nextElement();
			out.println(name+"&nbsp;");
		}
		
		out.println("sitename==="+sitename);
		out.println("developer==="+developer);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
