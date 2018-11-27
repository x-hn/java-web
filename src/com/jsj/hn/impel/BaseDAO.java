package com.jsj.hn.impel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost/guestbook?useUnicode=true&characterEncoding=UTF-8";
	private String user="root";
	private String password="";

	protected Connection conn=null;
	protected PreparedStatement st=null;
	protected ResultSet rs=null;
	//加载数据库驱动
	{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//建立数据库链接
	protected Connection getConnection() {
		try {
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//关闭数据库链接
	protected void close(Connection conn,PreparedStatement st,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	public int updateBySql(String sql,Object[] obj) {
		int num=0;
		conn=this.getConnection();
		try {
			st=conn.prepareStatement(sql);
			if(obj!=null && obj.length>0) {
				for(int i=0;i<obj.length;i++) {
					st.setObject(i+1, obj[i]);
				}
			}
			num=st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return num;
	}
	public void queryBySql(String sql,Object[] obj) {
		conn=this.getConnection();
		try {
			st=conn.prepareStatement(sql);
			if(obj!=null && obj.length>0) {
				for(int i=0;i<obj.length;i++) {
					st.setObject(i+1, obj[i]);
				}
			}
			rs=st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
