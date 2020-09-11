package org.cskj.boot.shiro.controller;

import java.util.List;

import org.cskj.boot.shiro.bean.User;
import org.cskj.boot.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping(value="queryAllUser")
	public List<User> queryAllUser(){
		return userService.queryAllUser();
	}
	
	@PostMapping(value="addUser")
	public boolean addUser(@RequestBody User user) {
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		return userService.addUser(user) > 0 ? true : false;
	}
	
	@PostMapping(value="updateUser")
	public boolean updateUser(@RequestBody User user) {
		return userService.updateUser(user) > 0 ? true : false;
	}
	
	@PostMapping(value="deleteUser")
	public boolean deleteUser(@RequestBody User user) {
		return userService.deleteUser(user) > 0 ? true : false;
	}
}
