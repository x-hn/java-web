package com.jsj.hn.DAO;

import java.util.List;

import com.jsj.hn.model.Trole;
import com.jsj.hn.model.User;

public interface IroleName {
	/*
	 * 增加信息
	 */
	public abstract int add(Trole role);
	
	/*
	 * 删除信息
	 */
	public abstract int delete(int id);
	/*
	 * 修改信息
	 */
	public abstract int update(Trole role);
	/*
	 * 查询单条数据
	 */
	public abstract Trole get(int id);
	/*
	 * 查询表上所有信息
	 */
	public abstract List<Trole> getAll();
}
