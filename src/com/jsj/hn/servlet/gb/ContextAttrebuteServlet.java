package com.jsj.hn.servlet.gb;
/**
 * 数据库分页
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContextAttrebuteServlet")
public class ContextAttrebuteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public ContextAttrebuteServlet() {
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		ServletContext context=super.getServletContext();
		
		Integer count=(Integer) context.getAttribute("count");
		if(count == null) {
			count = 1;
		}else {
			count=count+1;
		}
		context.setAttribute("count", count);
		PrintWriter out=response.getWriter();
		out.println("<p>本请求地址目前访问的人数是："+count+"</p>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
		
	}
}
