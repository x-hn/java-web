package com.jsj.hn.DAO;

import java.util.List;

import com.jsj.hn.model.User;

public interface IuserDAO {
	/*
	 * 增加信息
	 */
	public abstract int add(User user);
	
	/*
	 * 删除信息
	 */
	public abstract int delete(int id);
	/*
	 * 修改信息
	 */
	public abstract int update(User user);
	/*
	 * 查询单条数据
	 */
	public abstract User get(int id);
	/*
	 * 查询表上所有信息
	 */
	public abstract List<User> getAll();
	/*
	 * 验证用户名和密码
	 */
	public boolean login(String username,String password);
	
	public boolean repeat(String username);
	
	public int idTest(String usernaem);
}
