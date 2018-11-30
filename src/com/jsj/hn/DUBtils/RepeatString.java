package com.jsj.hn.DUBtils;

import com.jsj.hn.DAO.IuserDAO;
import com.jsj.hn.impel.userImpel;

public class RepeatString {
	public static boolean isRepeatString(String str) {
		IuserDAO userDAO=new userImpel();
		if(userDAO.repeat(str)) {
			return true;
		}else {
			return false;
		}
	} 
}
