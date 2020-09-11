package org.cskj.boot.shiro.service;

import java.util.List;

import org.cskj.boot.shiro.bean.User;

public interface UserService {

	public List<User> queryAllUser();

	public int addUser(User user);

	public int updateUser(User user);

	public int deleteUser(User user);
}
