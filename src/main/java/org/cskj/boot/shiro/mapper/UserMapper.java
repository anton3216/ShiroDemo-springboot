package org.cskj.boot.shiro.mapper;

import java.util.List;

import org.cskj.boot.shiro.bean.User;

public interface UserMapper {

	public List<User> queryAllUser();
	
	public int addUser(User user);
	
	public int updateUser(User user);

	public void deleteUser(int id);
}
