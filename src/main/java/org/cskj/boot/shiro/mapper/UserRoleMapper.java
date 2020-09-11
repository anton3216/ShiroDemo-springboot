package org.cskj.boot.shiro.mapper;

import java.util.List;

import org.cskj.boot.shiro.bean.User;
import org.cskj.boot.shiro.bean.UserRole;

public interface UserRoleMapper {

	void deleteByUid(int uid);
	
	void addUserRole(UserRole userRole);
}
