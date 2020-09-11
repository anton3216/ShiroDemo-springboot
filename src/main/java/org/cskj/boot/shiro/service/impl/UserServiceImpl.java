package org.cskj.boot.shiro.service.impl;

import java.util.List;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.cskj.boot.shiro.bean.Role;
import org.cskj.boot.shiro.bean.User;
import org.cskj.boot.shiro.bean.UserRole;
import org.cskj.boot.shiro.mapper.UserMapper;
import org.cskj.boot.shiro.mapper.UserRoleMapper;
import org.cskj.boot.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		List<User> list = userMapper.queryAllUser();
		for (User user : list) {
			String roles = "";
			List<UserRole> userRole_list = user.getUserRole();
			if (userRole_list != null && userRole_list.size() != 0) {
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

	@Override
	public int addUser(User user) {
		String password = user.getPassword();
		// 生成随机盐
		String salt = new SecureRandomNumberGenerator().nextBytes().toString();
		// 使用md5进行加密-2次
		String encodedPassword = new SimpleHash("md5", password, salt, 2).toString();
		// 将加密之后的密码 和 盐 都放入user对象中
		user.setPassword(encodedPassword);
		user.setSalt(salt);
		return userMapper.addUser(user);
	}

	@Override
	public int updateUser(User user) {
		int i = 0;
		try {
			String password = user.getPassword();
			// 生成随机盐
			String salt = new SecureRandomNumberGenerator().nextBytes().toString();
			// 使用md5进行加密-2次
			String encodedPassword = new SimpleHash("md5", password, salt, 2).toString();
			// 将加密之后的密码 和 盐 都放入user对象中
			user.setPassword(encodedPassword);
			user.setSalt(salt);
			// 正常做user的修改
			userMapper.updateUser(user);
			// 先删除
			userRoleMapper.deleteByUid(user.getId());
			// 再添加
			List<UserRole> userRole = user.getUserRole();
			for (UserRole ur : userRole) {
				ur.setUser(user);
				userRoleMapper.addUserRole(ur);
			}
			i = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteUser(User user) {
		int i = 0;
		try {
			//删除user
			userMapper.deleteUser(user.getId());
			//删除userRole
			userRoleMapper.deleteByUid(user.getId());
			i = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}

}
