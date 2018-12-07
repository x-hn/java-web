package com.jsj.hn.servlet.gb;

import java.io.IOException;
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
import com.jsj.hn.DUBtils.GetPassword;
import com.jsj.hn.impel.messageImpel;
import com.jsj.hn.model.Message;
@WebServlet("/message")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 2412704431604875678L;
	private Imessage messageDAO=new messageImpel();
	private Message message=new Message();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String type=request.getParameter("type");
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("loginname");
		String updateTitle=request.getParameter("updateTitle");
		String updateContent=request.getParameter("updateContent");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy"+"年"+"MM"+"月"+"dd"+"日");
		

		if(type.equals("addMessage")) {
			addMessage(request, response, username, sdf,session);
		}
		if(type.equals("deleteMessage")) {
			deleteMessage(request, response, session);
		}
		if(type.equals("updateMessage")) {
			updateMessage(request, response, session, username, updateTitle, updateContent);
		}

	}
	//编辑已存在留言
	private void updateMessage(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String username, String updateTitle, String updateContent) throws ServletException, IOException {
		int messageId=GetId.getMessageId((GetId.getUserId(username)));
		if(DUBtilsString.isNotNullandEmpety(updateTitle)&&DUBtilsString.isNotNullandEmpety(updateContent)) {
			message.setId(messageId);
			message.setTitle(updateTitle);
			message.setContent(updateContent);
			message.setCreateDateTime(new Date());
			messageDAO.update(message);
			session.removeAttribute("title");
			session.removeAttribute("content");
			session.setAttribute("updateTitle", updateTitle);
			session.setAttribute("updateContent", updateContent);
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}
	//实现删除留言的功能
	private void deleteMessage(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		session.removeAttribute("title");
		session.removeAttribute("content");
		session.removeAttribute("updateTitle");
		session.removeAttribute("updateContent");
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
	//增加留言
	private void addMessage(HttpServletRequest request, HttpServletResponse response, String username,
			SimpleDateFormat sdf,HttpSession session) throws ServletException, IOException {
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String time=sdf.format(new Date());
		if(DUBtilsString.isNotNullandEmpety(title)&&DUBtilsString.isNotNullandEmpety(content)) {
			message.setTitle(title);
			message.setContent(content);
			message.setCreateDateTime(new Date());
			message.setUserId(GetId.getUserId(username));
			messageDAO.add(message);
			session.setAttribute("title", title);
			session.setAttribute("content", content);
			session.setAttribute("time", time);
			RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
