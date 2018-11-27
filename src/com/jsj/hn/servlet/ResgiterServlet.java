package com.jsj.hn.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsj.hn.DAO.IuserDAO;
import com.jsj.hn.impel.userImpel;
import com.jsj.hn.model.User;
@WebServlet("/resgiter")
public class ResgiterServlet extends HttpServlet {
	IuserDAO userDAO=new userImpel();
	User user=new User();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String password1=request.getParameter("password1");
		if(username!="" && password!="" && password1!="" && password.equals(password1)) {
			user.setUserName(username);
			user.setPassWord(password);
			userDAO.add(user);
			RequestDispatcher rd=request.getRequestDispatcher("/resgiterSussce.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/resgiterdefeat.jsp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
