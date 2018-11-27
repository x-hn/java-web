package com.jsj.hn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsj.hn.DAO.IuserDAO;
import com.jsj.hn.impel.userImpel;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	IuserDAO userDAO=new userImpel();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		boolean flag=userDAO.login(username, password);
		
		//PrintWriter out=response.getWriter();
		if(flag) {
			//请求转发方式，可携带数据
			request.setAttribute("name", username);
			
			RequestDispatcher rd=request.getRequestDispatcher("/loginTest.jsp");
					rd.forward(request, response);
		}else {
			/*
			 * 可以跳转到指定页面或指定Servlet
			 * 重定向,如果在某个目录下则需要加上路径
			 */
			response.sendRedirect(request.getContextPath()+"/mistake.jsp");
			/*try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
}
