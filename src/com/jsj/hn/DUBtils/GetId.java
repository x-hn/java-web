package com.jsj.hn.DUBtils;

import com.jsj.hn.DAO.Imessage;
import com.jsj.hn.DAO.IuserDAO;
import com.jsj.hn.impel.messageImpel;
import com.jsj.hn.impel.userImpel;

public class GetId {
	public static int getUserId(String str) {
		IuserDAO userDAO=new userImpel();
		int userId=(userDAO.Test(str)).getId();
		return userId;
	}
	public static int getMessageId(int userId) {
		Imessage messageDAO=new messageImpel();
		int messageId=(messageDAO.messageId(userId)).getId();
		
		return messageId;
	}
}
