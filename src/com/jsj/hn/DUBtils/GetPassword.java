package com.jsj.hn.DUBtils;

import com.jsj.hn.DAO.IuserDAO;
import com.jsj.hn.impel.userImpel;

public class GetPassword {
	public static String getPassword(String str) {
		IuserDAO userDAO=new userImpel();
		String id=(userDAO.Test(str)).getPassWord();
		return id;
	}
}
