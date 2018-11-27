package com.jsj.hn.test;

import java.util.List;

import com.jsj.hn.DAO.IuserDAO;
import com.jsj.hn.impel.userImpel;
import com.jsj.hn.model.User;

public class Test {

	public static void main(String[] args) {
		
	}
	/*@org.junit.Test
	public void addTest() {
		IuserDAO userDAO=new userImpel();
		User user=new User();
		user.setUserName("hn");
		user.setPassWord("187");
		user.setRoleId(2);
		userDAO.add(user);
	}
	@org.junit.Test
	public void deleteTest() {
		IuserDAO userDAO=new userImpel();
		userDAO.delete(30);
	}
	@org.junit.Test
	public void updateTest() {
		IuserDAO userDAO=new userImpel();
		User user=new User();
		user.setId(29);
		user.setUserName("hn");
		user.setPassWord("187");
		user.setRoleId(1);
		userDAO.update(user);
	}
	@org.junit.Test
	public void getTest() {
		IuserDAO userDAO=new userImpel();
		System.out.println((userDAO.get(29)).toString());
	}
	@org.junit.Test
	public void getTest() {
		IuserDAO userDAO=new userImpel();
		User user=new User();
		List<User> list=userDAO.getAll();
		for(User s:list) {
			System.out.println(s.toString());
		}
	}*/
}
