package com.jsj.hn.servlet.ch3;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContextAppInfoServlet")
public class ContextAppInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContextAppInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		ServletContext context=super.getServletContext();
		//当前Web应用的上下文根路径
		String contextPath=context.getContextPath();
		//当前Web应用的名称
		String contextName=context.getServletContextName();
		//获取Web容器的名字和版本
		String serverInfo=context.getServerInfo();
		//获取Web容器支持的ServletAPI的主版本号
		int majorVersion=context.getMajorVersion();
		//获取Web容器支持的ServletAPI的次版本号
		int minjorVersion=context.getMinorVersion();
		
		System.out.println("当前Web应用的上下文根路径: "+contextPath);
		System.out.println("当前Web应用的名称: "+contextName);
		System.out.println("Web容器的名字和版本："+serverInfo);
		System.out.println("Web容器支持的ServletAPI的主版本号"+majorVersion);
		System.out.println("Web容器支持的ServletAPI的次版本号"+minjorVersion);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
