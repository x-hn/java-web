package com.jsj.hn.model;

public class Trole {
	private Integer id;
	private String roleName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
