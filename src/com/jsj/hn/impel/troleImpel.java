package com.jsj.hn.impel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsj.hn.DAO.IroleName;
import com.jsj.hn.model.Trole;
import com.jsj.hn.model.User;

public class troleImpel extends BaseDAO implements IroleName {

	@Override
	public int add(Trole role) {
		String sql="insert into trole(rolename) values(?)";
		Object[] obj=new Object[] {role.getRoleName()};
		return this.updateBySql(sql, obj);
	}

	@Override
	public int delete(Integer id) {
		String sql="delete from trole where id="+id;
		Object[] obj=new Object[] {};
		return this.updateBySql(sql, obj);
	}

	@Override
	public int update(Trole role) {
		String sql="update trole set rolename=? where id=?";
		Object[] obj=new Object[]{role.getRoleName(),role.getId()};
		return this.updateBySql(sql, obj);
	}

	@Override
	public Trole get(Integer id) {
		Trole role=new Trole();
		String sql="select * from trole where id="+id;
		Object[] obj=new Object[] {};
		this.queryBySql(sql, obj);
		try {
			while(rs.next()) {
				role.setId(rs.getInt("id"));
				role.setRoleName(rs.getString("rolename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public List<Trole> getAll() {
		List<Trole> list=new ArrayList<>();
		String sql="select * from trole";
		Object[] obj=new Object[] {};
		this.queryBySql(sql, obj);
		try {
			while(rs.next()) {
				Trole role=new Trole();
				role.setId(rs.getInt("id"));
				role.setRoleName(rs.getString("rolename"));
				list.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean repeat(String rolename) {
		Trole role=null;
		String sql="select * from trole where rolename=?";
		Object[] obj=new Object[] {rolename};
		this.queryBySql(sql, obj);
		try {
			while(rs.next()) {
				role=new Trole();
				role.setRoleName(rs.getString("rolename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return role==null?false:true;
	}

	@Override
	public List<Trole> getAll(int page, int pageSizes) {
		List<Trole> list=new ArrayList<>();
		String sql="select * from trole limit ?,?";
		int beginIndex=(page-1)*pageSizes;
		Object[] obj=new Object[] {beginIndex,pageSizes};
		this.queryBySql(sql, obj);
		try {
			while(rs.next()) {
				Trole role=new Trole();
				role.setId(rs.getInt("id"));
				role.setRoleName(rs.getString("rolename"));
				list.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return list;
	}

}
