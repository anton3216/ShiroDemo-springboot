package org.cskj.boot.shiro.controller;

import java.util.List;

import org.cskj.boot.shiro.bean.User;
import org.cskj.boot.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping(value="queryAllUser")
	public List<User> queryAllUser(){
		return userService.queryAllUser();
	}
}
