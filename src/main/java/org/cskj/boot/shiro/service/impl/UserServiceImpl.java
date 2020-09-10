package org.cskj.boot.shiro.service.impl;

import java.util.List;

import org.cskj.boot.shiro.bean.User;
import org.cskj.boot.shiro.bean.UserRole;
import org.cskj.boot.shiro.mapper.UserMapper;
import org.cskj.boot.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		List<User> list = userMapper.queryAllUser();
		for (User user : list) {
			String roles = "";
			List<UserRole> userRole_list = user.getUserRole();
			if(userRole_list != null && userRole_list.size() != 0) {
				for (UserRole userRole : userRole_list) {
					String name = userRole.getRole().getName();
					roles += "," + name;
				}
				roles = roles.substring(1);
				user.setRoles(roles);
				roles = "";
			}
		}
		return list;
	}
	
	
}
