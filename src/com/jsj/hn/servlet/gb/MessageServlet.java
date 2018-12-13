package com.jsj.hn.servlet.gb;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsj.hn.DAO.Imessage;
import com.jsj.hn.DUBtils.DUBtilsString;
import com.jsj.hn.DUBtils.GetId;
import com.jsj.hn.impel.messageImpel;
import com.jsj.hn.model.Message;
import com.jsj.hn.model.User;
@WebServlet("/message")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 2412704431604875678L;
	private Imessage messageDAO=new messageImpel();
	private Message message=new Message();
	private User loginU;
	private SimpleDateFormat sdf;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession();
		loginU=(User) session.getAttribute("loginUser");
		String type=request.getParameter("type");
		String updateTitle=request.getParameter("updateTitle");
		String updateContent=request.getParameter("updateContent");
		sdf=new SimpleDateFormat("yyyy"+"年"+"MM"+"月"+"dd"+"日");
		PrintWriter out=response.getWriter();

		if(type.equals("addMessage")) {
			addMessage(request, response,session);
		}
		if(type.equals("deleteMessage")) {
			deleteMessage(request, response, session);
		}
		if(type.equals("updateMessage")) {
			updateMessage(request, response, session, updateTitle, updateContent);
		}


	}
	//编辑已存在留言
	private void updateMessage(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String updateTitle, String updateContent) throws ServletException, IOException {
		int messageId=GetId.getMessageId((loginU.getId()));
		if(DUBtilsString.isNotNullandEmpety(updateTitle)&&DUBtilsString.isNotNullandEmpety(updateContent)) {
			message.setId(messageId);
			message.setTitle(updateTitle);
			message.setContent(updateContent);
			message.setCreateDateTime(new Date());
			message.setUserId(loginU.getId());
			messageDAO.update(message);
			session.setAttribute("updateTitle", updateTitle);
			session.setAttribute("updateContent", updateContent);
			response.sendRedirect(request.getContextPath()+"/index");
		}
	}
	//实现用户删除留言的功能
	private void deleteMessage(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		messageDAO.delete(Integer.parseInt(id));
		response.sendRedirect(request.getContextPath()+"/index");
	}
	//增加留言
	private void addMessage(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws ServletException, IOException {
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String time=sdf.format(new Date());
		if(DUBtilsString.isNotNullandEmpety(title)&&DUBtilsString.isNotNullandEmpety(content)) {
			message.setTitle(title);
			message.setContent(content);
			message.setCreateDateTime(new Date());
			message.setUserId(loginU.getId());
			messageDAO.add(message);
			session.setAttribute("title", title);
			session.setAttribute("content", content);
			session.setAttribute("time", time);
			response.sendRedirect(request.getContextPath()+"/index");
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
