package com.jsj.hn.DUBtils;

import com.jsj.hn.DAO.IuserDAO;
import com.jsj.hn.impel.userImpel;

public class GetId {
	public static int getId(String str) {
		IuserDAO userDAO=new userImpel();
		int id=(userDAO.Test(str)).getId();
		return id;
	}
}
