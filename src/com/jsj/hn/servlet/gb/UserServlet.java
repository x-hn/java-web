package com.jsj.hn.servlet.gb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsj.hn.DAO.IuserDAO;
import com.jsj.hn.DUBtils.DUBtilsString;
import com.jsj.hn.DUBtils.GetPassword;
import com.jsj.hn.impel.userImpel;
import com.jsj.hn.model.User;
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = -118660327338658366L;
	private IuserDAO userDAO=new userImpel();
	private User user=new User();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String type=request.getParameter("type");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String isUserCookie=request.getParameter("isUserCookie");

		if(type.equals("login")) {
			login(request, response, username, password, out,session,isUserCookie);
		}
		if(type.equals("resgiter")) {
			resgiter(request, response, username, password,out);
		}
		if(type.equals("cancel")) {
			cancel(request, response, username, session);		
		}
	}
	//注销
	private void cancel(HttpServletRequest request, HttpServletResponse response, String username, HttpSession session)
			throws IOException, ServletException {
		session.removeAttribute("loginname");
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
	//注册
	private void resgiter(HttpServletRequest request, HttpServletResponse response, String username, String password,PrintWriter out)
			throws ServletException, IOException {
		String password1=request.getParameter("password1");
		if(DUBtilsString.isNotNullandEmpety(username) && DUBtilsString.isNotNullandEmpety(password)&&DUBtilsString.isNotNullandEmpety(password1)&&password.equals(password1)) {
			if(userDAO.repeat(username)) {
				request.setAttribute("regInfo", "用户名已存在！！");
				RequestDispatcher rd=request.getRequestDispatcher("/resgiter.jsp");
				rd.forward(request, response);
			}else {
				user.setUserName(username);
				user.setPassWord(password);
				userDAO.add(user);
				RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			}
		}
	}

	//登录
	private void login(HttpServletRequest request, HttpServletResponse response, String username, String password,
			PrintWriter out, HttpSession session,String isUserCookie) throws ServletException, IOException {
		if(DUBtilsString.isNotNullandEmpety(username) || DUBtilsString.isNotNullandEmpety(password)) {
			boolean flag=userDAO.login(username, password);
			if(flag) {
				//判断是否记住登录状态
				if(isUserCookie!=null) {
					Cookie usernameCookie=new Cookie("username",username);
					Cookie passwordCookie=new Cookie("password",password);
					usernameCookie.setMaxAge(7*24*60*60);
					passwordCookie.setMaxAge(7*24*60*60);
					response.addCookie(usernameCookie);
					response.addCookie(passwordCookie);
				}else {
					Cookie[] cookie=request.getCookies();
					if(cookie!=null && cookie.length>0) {
						for(Cookie cookies:cookie) {
							if(cookies.getName().equalsIgnoreCase("username")||cookies.getName().equalsIgnoreCase("password")) {
								cookies.setMaxAge(0);
								response.addCookie(cookies);
							}
						}
					}
				}
				//请求转发方式，可携带数据
				session.setAttribute("loginname", username);
				RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("loginname", "用户名或密码错误！");
				RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
