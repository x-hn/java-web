package com.jsj.hn.impel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsj.hn.DAO.IuserDAO;
import com.jsj.hn.model.Message;
import com.jsj.hn.model.User;

public class userImpel extends BaseDAO implements IuserDAO {

	@Override
	public int add(User user) {
		String sql="insert into tuser(username,password,roleid) values(?,?,?)";
		Object[] obj=new Object[] {user.getUserName(),user.getPassWord(),user.getRoleId()};
		return this.updateBySql(sql, obj);
	}

	@Override
	public int delete(Integer id) {
		String sql="delete from tuser where id="+id;
		Object[] obj=new Object[] {};
		return this.updateBySql(sql, obj);
	}

	@Override
	public int update(User user) {
		String sql="update tuser set username=?,password=?,roleid=? where id=?";
		Object[] obj=new Object[] {user.getUserName(),user.getPassWord(),user.getRoleId(),user.getId()};
		return this.updateBySql(sql, obj);
	}

	@Override
	public User get(Integer id) {
		User user=new User();
		String sql="select * from tuser where id="+id;
		Object[] obj=new Object[] {};
		this.queryBySql(sql, obj);
		try {
			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setPassWord(rs.getString("password"));
				user.setRoleId(rs.getInt("roleid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return user;
	}

	@Override
	public List<User> getAll() {
		List<User> list=new ArrayList<>();
		String sql="select * from tuser";
		Object[] obj=new Object[] {};
		this.queryBySql(sql, obj);
		try {
			while(rs.next()) {
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setPassWord(rs.getString("password"));
				user.setRoleId(rs.getInt("roleid"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return list;
	}

	@Override
	public User login(String username, String password) {
		User user=null;
		String sql="select * from tuser where username=? and password=?";
		Object[] obj=new Object[] {username,password};
		this.queryBySql(sql, obj);
		try {
			while(rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setPassWord(rs.getString("password"));
				user.setRoleId(rs.getInt("roleid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return user;
	}

	@Override
	public boolean repeat(String username) {
		User user=null;
		String sql="select * from tuser where username=?";
		Object[] obj=new Object[] {username};
		this.queryBySql(sql, obj);
		try {
			while(rs.next()) {
				user=new User();
				user.setUserName(rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return user==null?false:true;
	}

	

	@Override
	public List<User> getAll(int page, int pageSizes) {
		List<User> list=new ArrayList<>();
		String sql="select * from tuser limit ?,?";
		int beginIndex=(page-1)*pageSizes;
		Object[] obj=new Object[] {beginIndex,pageSizes};
		this.queryBySql(sql, obj);
		try {
			while(rs.next()) {
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setPassWord(rs.getString("password"));
				user.setRoleId(rs.getInt("roleid"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return list;
	}
	
	@Override
	public int count(String sql,Object[] obj) {
		this.queryBySql(sql, obj);
		int countTest=-1;
		try {
			while(rs.next()) {
				countTest=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return countTest;
	}
}
