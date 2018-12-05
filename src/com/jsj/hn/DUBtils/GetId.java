package com.jsj.hn.DUBtils;

import com.jsj.hn.DAO.Imessage;
import com.jsj.hn.DAO.IuserDAO;
import com.jsj.hn.impel.messageImpel;
import com.jsj.hn.impel.userImpel;

public class GetId {
	public static int getId(String str) {
		IuserDAO userDAO=new userImpel();
		int id=(userDAO.Test(str)).getId();
		return id;
	}
	public static int getMessageId(String str) {
		Imessage messageDAO=new messageImpel();
		int id=(messageDAO.Test(str)).getId();
		return id;
	}
}
