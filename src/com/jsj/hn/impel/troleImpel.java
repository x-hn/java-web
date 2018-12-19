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

}
