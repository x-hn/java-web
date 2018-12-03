package com.jsj.hn.DAO;

import java.util.List;

import com.jsj.hn.model.Message;

public interface Imessage {
	/*
	 * 增加信息
	 */
	public abstract int add(Message message);
	
	/*
	 * 删除信息
	 */
	public abstract int delete(int id);
	/*
	 * 修改信息
	 */
	public abstract int update(Message message);
	/*
	 * 查询单条数据
	 */
	public abstract Message get(int id);
	/*
	 * 查询表上所有信息
	 */
	public abstract List<Message > getAll();
	/*
	 * 查询单个信息
	 */
}
