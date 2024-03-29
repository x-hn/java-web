package com.jsj.hn.DAO;

import java.util.List;

import com.jsj.hn.model.Message;
import com.jsj.hn.model.User;

public interface IuserDAO {
	/*
	 * 增加信息
	 */
	public abstract int add(User user);
	
	/*
	 * 增加信息(默认roleid)
	 */
	public abstract int addValueRole(User user);
	
	/*
	 * 删除信息
	 */
	public abstract int delete(Integer id);
	/*
	 * 修改信息
	 */
	public abstract int update(User user);
	/*
	 * 查询单条数据
	 */
	public abstract User get(Integer id);
	/*
	 * 查询表上所有信息
	 */
	public abstract List<User> getAll();
	/*
	 * 验证用户名和密码
	 */
	public User login(String username,String password);
	/*
	 * 判断用户名是否重复
	 */
	public boolean repeat(String username);
	//数据库分页
	public abstract List<User> getAll(int page, int pageSizes);
	//重置密码
	public abstract int valuePassword(User user);


}
