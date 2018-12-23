package com.jsj.hn.servlet.gb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsj.hn.DAO.IroleName;
import com.jsj.hn.DAO.IuserDAO;
import com.jsj.hn.DUBtils.DUBtilsString;
import com.jsj.hn.impel.BaseDAO;
import com.jsj.hn.impel.troleImpel;
import com.jsj.hn.impel.userImpel;
import com.jsj.hn.model.Message;
import com.jsj.hn.model.User;
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = -118660327338658366L;
	private IuserDAO userDAO=new userImpel();
	private IroleName roleDAO=new troleImpel();
	private BaseDAO baseDAO=new BaseDAO();
	private User user=new User();
	private String sessionCode;
	private User loginU;
	private HttpSession session;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String type=request.getParameter("type");
		String isUserCookie=request.getParameter("isUserCookie");
		String isUser=request.getParameter("isUser");
		
		session=request.getSession();
		loginU=(User) session.getAttribute("loginUser");
		sessionCode=(String)session.getAttribute("ValidateCode");

		PrintWriter out=response.getWriter();
		if(type.equals("login")) {
			login(request, response, username, password, out,session,isUserCookie);
		}else if(type.equals("resgiter")) {
			resgiter(request, response, username, password,out);
		}else if(type.equals("cancel")) {
			cancel(request, response, username, session);		
		}else if(type.equals("getAll")) {
			getAll(request, response);
		}else if(type.equals("edit")) {
			edit(request, response, username, password);
		}else if(type.equals("get")) {
			get(request, response);
		}else if(type.equals("addUser")) {
			addUser(request, response, username, password);
		}else if(type.equals("delete")) {
			deleteUser(request, response);
		}else if(type.equals("value")) {
			valuePassword(request, response);
		}
	}
	//重置密码
	private void valuePassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
		user.setId(id);
		user.setPassWord("0000");
		userDAO.valuePassword(user);
		response.sendRedirect(request.getContextPath()+"/user?type=getAll");
	}
	//删除用户信息
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
		userDAO.delete(id);
		response.sendRedirect(request.getContextPath()+"/user?type=getAll");
	}
	//增加用户信息
	private void addUser(HttpServletRequest request, HttpServletResponse response, String username, String password)
			throws ServletException, IOException {
		String password1=request.getParameter("password1");
		if(DUBtilsString.isNotNullandEmpety(username) && DUBtilsString.isNotNullandEmpety(password)&&DUBtilsString.isNotNullandEmpety(password1)&&password.equals(password1)) {
			if(userDAO.repeat(username)) {
				request.setAttribute("regInfo", "用户名已存在！！");
				RequestDispatcher rd=request.getRequestDispatcher("/admin/user/addUser.jsp");
				rd.forward(request, response);
			}else {
				user.setUserName(username);
				user.setPassWord(password);
				userDAO.addValueRole(user);
				response.sendRedirect(request.getContextPath()+"/user?type=getAll");
			}
		}
	}
	//通过id编辑用户信息
	private void edit(HttpServletRequest request, HttpServletResponse response, String username, String password)
			throws IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
		user.setId(id);
		user.setUserName(username);
		user.setPassWord(password);
		userDAO.update(user);
		response.sendRedirect(request.getContextPath()+"/user?type=getAll");
	}
	//通过id获取该对象
	private void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		User u=userDAO.get(Integer.parseInt(id));
		request.setAttribute("user", u);
		RequestDispatcher rd=request.getRequestDispatcher("admin/user/editUser.jsp");
		rd.forward(request, response);
	}
	//用户管理
	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//当前页
		String p=request.getParameter("page");
		int page;
		try {
			page=Integer.valueOf(p);
		} catch (Exception e) {
			page=1;
		}
		//每页页数
		int pageSizes=3;
		//开始索引
		int beginIndex=(page-1)*pageSizes;
		
		List<User> userList=userDAO.getAll(page,pageSizes);
		
		for(User u:userList) {
			if(u.getRoleId()!=null) {
				u.setRolename((roleDAO.get(u.getRoleId())).getRoleName());
			}
		}
		String sql="SELECT COUNT(*) FROM tuser where 1=1";
		Object[] obj=new Object[] {};
		//总记录数
		int totalRecords=baseDAO.count(sql,obj);
		//总页数
		int totalPages=totalRecords % pageSizes ==0?totalRecords / pageSizes:totalRecords / pageSizes +1;
		//结束索引
		int endIndex=beginIndex+pageSizes;
		if(endIndex>totalRecords) {
			endIndex=totalRecords;
		}
		request.setAttribute("page", page);
		request.setAttribute("totalRecords", totalRecords);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("beginIndex", beginIndex);
		request.setAttribute("endIndex", endIndex);
		request.setAttribute("pageSizes", pageSizes);
		request.setAttribute("userList", userList);
		RequestDispatcher rd=request.getRequestDispatcher("/admin/user/users.jsp");
		rd.forward(request, response);
	}
	//注销
	private void cancel(HttpServletRequest request, HttpServletResponse response, String username, HttpSession session)
			throws IOException, ServletException {
		session.removeAttribute("loginUser");
		session.invalidate();
		response.sendRedirect(request.getContextPath()+"/index");
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
				user.setRoleId(2);
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
			String verifyCode=request.getParameter("verifyCode");
			User u=userDAO.login(username, password);
			if(u!=null) {
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
				if(sessionCode.equals(verifyCode)) {
					session.setAttribute("loginUser", u);
					response.sendRedirect(request.getContextPath()+"/index");
				}else {
					request.setAttribute("validateCode", "请输入正确的验证码！");
					RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
					rd.forward(request, response);
				}
				
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
