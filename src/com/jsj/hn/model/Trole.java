package com.jsj.hn.model;

public class Trole {
	private int id;
	private String roleName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "Trole [id=" + id + ", roleName=" + roleName + "]";
	}
	
}
