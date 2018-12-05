package com.jsj.hn.servlet.gb;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String username=request.getParameter("username");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy"+"年"+"MM"+"月"+"dd"+"日");
		
		if(type.equals("addMessage")) {
			addMessage(request, response, username, sdf);
		}
		if(type.equals("deleteMessage")) {
			String password=request.getParameter("password");
			String pass=GetPassword.getPassword(username);
			if( DUBtilsString.isNotNullandEmpety(password) && pass.equals(password) ) {
				String title=request.getParameter("title");
				messageDAO.delete(GetId.getMessageId(title));
				request.setAttribute("username", username);
				RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("messInfo", "用户名或密码错误!");
				RequestDispatcher rd=request.getRequestDispatcher("/deleteMessage.jsp");
				rd.forward(request, response);
			}
		}

	}
	//增加留言
	private void addMessage(HttpServletRequest request, HttpServletResponse response, String username,
			SimpleDateFormat sdf) throws ServletException, IOException {
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String time=sdf.format(new Date());
		if(DUBtilsString.isNotNullandEmpety(title)&&DUBtilsString.isNotNullandEmpety(content)) {
			message.setTitle(title);
			message.setContent(content);
			message.setCreateDateTime(new Date());
			message.setUserId(GetId.getId(username));
			messageDAO.add(message);
			request.setAttribute("title", title);
			request.setAttribute("content", content);
			request.setAttribute("time", time);
			request.setAttribute("username", username);
			RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
