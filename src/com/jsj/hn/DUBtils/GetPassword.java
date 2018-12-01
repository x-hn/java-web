package com.jsj.hn.DUBtils;

import com.jsj.hn.DAO.IuserDAO;
import com.jsj.hn.impel.userImpel;

public class GetPassword {
	public static String getPassword(String username) {
		IuserDAO userDAO=new userImpel();
		String password=(userDAO.Test(username)).getPassWord();
		return password;
	}
}
