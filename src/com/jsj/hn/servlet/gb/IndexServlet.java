package com.jsj.hn.servlet.gb;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsj.hn.DAO.Imessage;
import com.jsj.hn.DAO.IroleName;
import com.jsj.hn.DAO.IuserDAO;
import com.jsj.hn.impel.messageImpel;
import com.jsj.hn.impel.troleImpel;
import com.jsj.hn.impel.userImpel;
import com.jsj.hn.model.Message;
import com.jsj.hn.model.User;
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Imessage messageDAO=new messageImpel();
	private IuserDAO userDAO=new userImpel();
	private IroleName roleDAO=new troleImpel();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		List<Message> messageList=messageDAO.getAll();
		for(Message m:messageList) {
			if(m.getUserId()!=null) {
				m.setUsername((userDAO.get(m.getUserId())).getUserName());
			}
		}
		request.setAttribute("messageList", messageList);
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
		
	}
}
