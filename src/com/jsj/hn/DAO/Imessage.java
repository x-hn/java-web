package com.jsj.hn.DAO;

import java.util.Date;
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
	public abstract int delete(Integer id);
	/*
	 * 修改信息
	 */
	public abstract int update(Message message);
	/*
	 * 修改标题和留言
	 */
	public abstract int updateTitleAndContent(Message message);
	/*
	 * 查询单条数据
	 */
	public abstract Message get(Integer id);
	/*
	 * 查询表上所有信息
	 */
	public abstract List<Message > getAll();
	/*
	 * 根据起始位置和查询数量查询信息
	 */
	public abstract List<Message> getAll(int page, int pageSizes);

}
