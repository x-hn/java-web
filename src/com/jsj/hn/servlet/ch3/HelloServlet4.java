package com.jsj.hn.servlet.ch3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/HelloServlet4")
public class HelloServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloServlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置客户端响应的文本类型
				response.setContentType("text/html;charset=UTF-8");
				//获取ServletContext 对象
				ServletContext context=super.getServletContext();
				//从ServletContext 对象获取count属性存放计数器的值
				Integer count=(Integer) context.getAttribute("count");
				
				if(count==null) {
					count=1;
				}else {
					count=count+1;
				}
				//将更新后的数值存储到ServletContext对象的count属性中
				context.setAttribute("count", count);
				PrintWriter out=response.getWriter();
				out.println("本网站目前访问人数:  "+count);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
