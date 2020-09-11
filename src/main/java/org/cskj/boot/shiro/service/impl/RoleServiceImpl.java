package org.cskj.boot.shiro.service.impl;

import java.util.List;

import org.cskj.boot.shiro.bean.Role;
import org.cskj.boot.shiro.mapper.RoleMapper;
import org.cskj.boot.shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> queryAllRole() {
		return roleMapper.queryAllRole();
	}

}
