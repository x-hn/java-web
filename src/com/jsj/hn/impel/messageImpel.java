package com.jsj.hn.impel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsj.hn.DAO.Imessage;
import com.jsj.hn.model.Message;
import com.jsj.hn.model.User;

public class messageImpel extends BaseDAO implements Imessage {

	@Override
	public int add(Message message) {
		String sql="insert into message(title,content,createDateTime,userId,pid) values(?,?,?,?,?)";
		Object[] obj=new Object[] {message.getTitle(),message.getContent(),message.getCreateDateTime(),message.getUserId(),message.getPid()};
		return this.updateBySql(sql, obj);
	}

	@Override
	public int delete(int id) {
		String sql="delete from message where id="+id;
		Object[] obj=new Object[] {};
		return this.updateBySql(sql, obj);
	}

	@Override
	public int update(Message message) {
		String sql="update message set title=?,content=?,createDateTime=?,userId=?,pid=? where id=?";
		Object[] obj=new Object[] {message.getTitle(),message.getContent(),message.getCreateDateTime(),message.getUserId(),message.getPid(),message.getId()};
		return this.updateBySql(sql, obj);
	}

	@Override
	public Message get(int id) {
		Message message=new Message();
		String sql="select * from message where id="+id;
		Object[] obj=new Object[] {};
		this.queryBySql(sql, obj);
		try {
			while(rs.next()) {
				message.setId(rs.getInt("id"));
				message.setTitle(rs.getString("title"));
				message.setContent(rs.getString("content"));
				message.setCreateDateTime(rs.getDate("createDateTime"));
				message.setUserId(rs.getInt("userId"));
				message.setPid(rs.getInt("pid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public List<Message> getAll() {
		List<Message> list=new ArrayList<>();
		String sql="select * from message";
		Object[] obj=new Object[] {};
		this.queryBySql(sql, obj);
		try {
			while(rs.next()) {
				Message message=new Message();
				message.setId(rs.getInt("id"));
				message.setTitle(rs.getString("title"));
				message.setContent(rs.getString("content"));
				message.setCreateDateTime(rs.getDate("createDateTime"));
				message.setUserId(rs.getInt("userId"));
				message.setPid(rs.getInt("pid"));
				list.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Message Test(String str) {
		Message message=new Message();
		String sql="select * from message where title=?";
		Object[] obj=new Object[] {str};
		this.queryBySql(sql, obj);
		try {
			while(rs.next()) {
				message.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return message;
	}

}
