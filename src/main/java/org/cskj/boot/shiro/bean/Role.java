package org.cskj.boot.shiro.bean;

import java.util.List;

public class Role {

	private int id;
	private String name;
	private String content;
	private List<RolePermission> rolePermission;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<RolePermission> getRolePermission() {
		return rolePermission;
	}

	public void setRolePermission(List<RolePermission> rolePermission) {
		this.rolePermission = rolePermission;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", content=" + content + ", rolePermission=" + rolePermission
				+ "]";
	}

}
