package com.jsj.hn.servlet.ch3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestLineServlet")
public class RequestLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestLineServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		//获取请求使用的HTTP方法
		String method=request.getMethod();
		//获取请求行中的资源部分
		StringBuffer uri=request.getRequestURL();
		//获取使用的协议及版本号
		String protocal=request.getProtocol();
		//获取Servlet所映射的路径
		String queryString=request.getServletPath();
		//获取请求资源所属于的Web应用的路径
		String contextPath=request.getContextPath();
		
		System.out.println("使用的HTTP方法: "+method);
		System.out.println("请求行中的资源部分: "+uri.toString());
		System.out.println("使用的协议及版本号 : "+protocal);
		System.out.println("Servlet所映射的路径: "+queryString);
		System.out.println("请求资源所属于的Web应用的路径: "+contextPath);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
